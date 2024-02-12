#pragma once

#include <atomic>

#if defined(__x86_64__)
#include <emmintrin.h>
inline auto pause() -> void { _mm_pause; }
#elif defined(__aarch64__)
inline auto pause() -> void { asm volatile("yield" ::: "memory"); }
#else
inline auto pause() -> void {}
#endif

class Spinlock {
 public:
  Spinlock() = default;
  ~Spinlock() = default;

 public:
  auto lock() -> void {
    while (true) {
      if (not b.exchange(true, std::memory_order_acquire)) {
        return;
      }
      while (b.load(std::memory_order_relaxed)) {
        pause();
      }
    }
  }

  auto try_lock() -> bool {
    return not b.load(std::memory_order_relaxed) and
           not b.exchange(true, std::memory_order_acquire);
  }

  auto unlock() -> void { b.store(false, std::memory_order_release); }

 private:
  std::atomic_bool b{false};
};