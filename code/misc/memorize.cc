/*
  Memorization for recursive function, inspired by @cache decorator in python.
*/
#include <chrono>
#include <functional>
#include <iostream>
#include <tuple>
#include <unordered_map>

template <class T> inline void HashCombine(std::size_t &seed, T const &v) {
  seed ^= std::hash<T>()(v) + 0x9e3779b9 + (seed << 6) + (seed >> 2);
}

template <class Tuple, size_t Index = std::tuple_size<Tuple>::value - 1>
struct HashValueImpl {
  static void apply(size_t &seed, Tuple const &tuple) {
    HashValueImpl<Tuple, Index - 1>::apply(seed, tuple);
    HashCombine(seed, std::get<Index>(tuple));
  }
};

template <class Tuple> struct HashValueImpl<Tuple, 0> {
  static void apply(size_t &seed, Tuple const &tuple) {
    HashCombine(seed, std::get<0>(tuple));
  }
};

template <typename... Ts> struct std::hash<std::tuple<Ts...>> {
  size_t operator()(std::tuple<Ts...> const &t) const {
    size_t seed = 0;
    HashValueImpl<std::tuple<Ts...>>::apply(seed, t);
    return seed;
  }
};

template <typename Fn>
struct FuncTraits : public FuncTraits<decltype(&Fn::operator())> {};

template <typename Fn, typename ReturnType, typename... ParamsType>
struct FuncTraits<ReturnType (Fn::*)(ParamsType...) const> {
  using R = ReturnType;

  template <size_t i>
  using ArgType =
      typename std::tuple_element<i, std::tuple<ParamsType...>>::type;

  using Args = std::tuple<ParamsType...>;
};

template <typename Fn> using FnArgs = FuncTraits<Fn>::Args;
template <typename Fn> using FnR = FuncTraits<Fn>::R;

template <typename Fn> struct Memorize {
  explicit Memorize(Fn fn) : fn(fn) {}

  template <typename... Args> auto operator()(Args... args) {
    auto key = std::make_tuple(args...);
    if (auto iter = memo.find(key); iter != memo.end()) {
      return iter->second;
    } else {
      auto value = fn(args...);
      memo[key] = value;
      return value;
    }
  }

  Fn fn;
  std::unordered_map<FnArgs<Fn>, FnR<Fn>> memo;
};

class Timer {
public:
  using clock = std::chrono::steady_clock; // monotonic clock
  using time_point = std::chrono::time_point<clock>;
  using seconds = std::chrono::seconds;
  using milliseconds = std::chrono::milliseconds;
  using microseconds = std::chrono::microseconds;
  using nanoseconds = std::chrono::nanoseconds;

public:
  Timer() = default;
  ~Timer() = default;

public:
  auto begin() -> void { b = clock::now(); }
  auto end() -> void { e = clock::now(); }

  template <typename T> auto elapsed() -> int {
    return std::chrono::duration_cast<T>(e - b).count();
  }

private:
  time_point b;
  time_point e;
};

class TimerGuard {
public:
  TimerGuard() { t.begin(); }
  ~TimerGuard() {
    t.end();
    std::cout << "Elapsed = " << t.elapsed<Timer::microseconds>() << "us"
              << std::endl;
  }

private:
  Timer t;
};

int main() {
  // fibonacci
  std::function<int(int)> naive_fib = [&](int n) -> int {
    if (n <= 1) {
      return n;
    } else {
      return naive_fib(n - 1) + naive_fib(n - 2);
    }
  };

  Memorize<std::function<int(int)>> memo_fib =
      Memorize(std::function<int(int)>([&](int n) -> int {
        if (n <= 1) {
          return n;
        } else {
          return memo_fib(n - 1) + memo_fib(n - 2);
        }
      }));

  {
    TimerGuard g;
    std::cout << "fib(40) = " << memo_fib(40) << std::endl;
  }
  {
    TimerGuard g;
    std::cout << "naive_fib(40) = " << naive_fib(40) << std::endl;
  }

  // integer partition
  std::function<int(int, int)> naive_p = [&](int n, int k) -> int {
    if (n == k) {
      return 1 + naive_p(n, k - 1);
    } else if (k == 0 || n < 0) {
      return 0;
    } else if (n == 0 || k == 1) {
      return 1;
    } else {
      return naive_p(n, k - 1) + naive_p(n - k, k);
    }
  };

  Memorize<std::function<int(int, int)>> memo_p =
      Memorize(std::function<int(int, int)>([&](int n, int k) -> int {
        if (n == k) {
          return 1 + memo_p(n, k - 1);
        } else if (k == 0 || n < 0) {
          return 0;
        } else if (n == 0 || k == 1) {
          return 1;
        } else {
          return memo_p(n, k - 1) + memo_p(n - k, k);
        }
      }));

  {
    TimerGuard g;
    std::cout << "memo_p(100, 40) = " << memo_p(100, 40) << std::endl;
  }
  {
    TimerGuard g;
    std::cout << "naive_p(100, 40) = " << naive_p(100, 40) << std::endl;
  }

  return 0;
}