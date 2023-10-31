#include "atomic"
#include "limits"
#include "linux/futex.h"
#include "stdint.h"
#include "sys/syscall.h"
#include "sys/time.h"
#include "unistd.h"

static inline long futex(uint32_t *uaddr, int futex_op, uint32_t val,
                         const timespec *timeout = nullptr,
                         uint32_t *uaddr2 = nullptr, uint32_t val3 = 0) {
  return syscall(SYS_futex, uaddr, futex_op, val, timeout, uaddr2, val3);
}

static inline long futex_wait(uint32_t *uaddr, uint32_t val, bool is_private,
                              const timespec *timeout = nullptr) {
  return futex(uaddr, is_private ? FUTEX_WAIT_PRIVATE : FUTEX_WAIT, val,
               timeout);
}

static inline long futex_wake(uint32_t *uaddr, uint32_t val, bool is_private) {
  return futex(uaddr, is_private ? FUTEX_WAKE_PRIVATE : FUTEX_WAKE, val);
}

static constexpr uint32_t PARKED = std::numeric_limits<uint32_t>::max();
static constexpr uint32_t EMPTY = 0;
static constexpr uint32_t NOTIFIED = 1;

class Parker {
private:
  bool is_private; // not shared between processes
  std::atomic_uint32_t park_futex{EMPTY};

public:
  explicit Parker(bool is_private = true) : is_private(is_private) {}

  void park() {
    if (park_futex.fetch_sub(1, std::memory_order_acquire) == NOTIFIED) {
      return;
    }
    while (true) {
      uint32_t notified = NOTIFIED;
      futex_wait(reinterpret_cast<uint32_t *>(&park_futex), PARKED, is_private,
                 nullptr);
      if (park_futex.compare_exchange_strong(notified, EMPTY,
                                             std::memory_order_acquire)) {
        return;
      }
      // spurious wake up
    }
  }

  void unpark() {
    if (park_futex.exchange(NOTIFIED, std::memory_order_release) == PARKED) {
      futex_wake(reinterpret_cast<uint32_t *>(&park_futex), 1, is_private);
    }
  }
};
