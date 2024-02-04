#include <algorithm>
#include <catch2/catch_test_macros.hpp>
#include <functional>
#include <optional>
#include <span>
#include <vector>

std::optional<int> top_k_of(std::span<int> v, int k) {
  if (v.empty() || k < 1 || k > v.size()) {
    return std::nullopt;
  }
  k--;
  std::function<int(int, int)> _top_k_of = [&](int lo, int hi) -> int {
    auto l = lo;
    auto r = hi;
    auto key = v[l];
    while (l < r) {
      while (l < r && v[r] <= key) {
        r--;
      }
      if (l < r) {
        v[l++] = v[r];
      }
      while (l < r && v[l] >= key) {
        l++;
      }
      if (l < r) {
        v[r--] = v[l];
      }
    }
    v[l] = key;
    if (l == k) {
      return v[l];
    } else if (l > k) {
      return _top_k_of(lo, l - 1);
    } else {
      return _top_k_of(l + 1, hi);
    }
  };

  return _top_k_of(0, v.size() - 1);
}

TEST_CASE("sorted and unsorted", "[vector]") {
  auto v = std::vector<int>{82, 231, 1234, 3525, 24, 2, 342, 5346, 754};
  SECTION("unsorted") {
    REQUIRE(top_k_of(v, 1).value() == 5346);
    REQUIRE(top_k_of(v, 4).value() == 754);
    REQUIRE(top_k_of(v, 5).value() == 342);
    REQUIRE(top_k_of(v, 9).value() == 2);
  }
  std::sort(v.begin(), v.end());
  SECTION("sorted") {
    REQUIRE(top_k_of(v, 1).value() == 5346);
    REQUIRE(top_k_of(v, 4).value() == 754);
    REQUIRE(top_k_of(v, 5).value() == 342);
    REQUIRE(top_k_of(v, 9).value() == 2);
  }
}
