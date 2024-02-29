#include <catch2/catch_test_macros.hpp>
#include <iostream>
#include <unordered_map>

auto get_prime_factor_of(int x) -> std::unordered_map<int, int> {
  auto result = std::unordered_map<int, int>();
  for (int i = 2; i <= x / i; i++) {
    if (x % i == 0) {
      auto &c = result[i];
      for (c = 0; x % i == 0; c++) {
        x /= i;
      }
    }
  }
  if (x > 1) {
    result[x]++;
  }
  return result;
}

TEST_CASE("Get Prime Factors of Number", "[normal case]") {
  SECTION("prime") {
    auto test = [](int prime) {
      REQUIRE(get_prime_factor_of(prime) ==
              std::unordered_map<int, int>{{prime, 1}});
    };
    test(1e9 + 7);
    test(2);
  }
  SECTION("composite") {
    auto test = [](int x, std::unordered_map<int, int> &&expected) {
      REQUIRE(get_prime_factor_of(x) == expected);
    };
    test(1024, {{2, 10}});
    test(1024 * 361 * 343, {{2, 10}, {19, 2}, {7, 3}});
  }
}

template <size_t LIMIT>
struct PrimeSet {
  std::vector<int> primes;
  bool not_prime[LIMIT];

  PrimeSet() {
    memset(not_prime, false, sizeof(not_prime));
    for (int i = 2; i < LIMIT; ++i) {
      if (!not_prime[i]) {
        primes.push_back(i);
      }
      for (int p : primes) {
        if (i * p >= LIMIT) {
          break;
        }
        not_prime[i * p] = true;
        if (i % p == 0) {
          break;
        }
      }
    }
  }

  auto get() -> std::vector<int> & { return primes; }
};

TEST_CASE("Prime Set", "[normal case]") {
  PrimeSet<100> s;
  auto expected =
      std::vector<int>{2,  3,  5,  7,  11, 13, 17, 19, 23, 29, 31, 37, 41,
                       43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
  REQUIRE(s.get() == expected);
}