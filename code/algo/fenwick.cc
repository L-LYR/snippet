#include <catch2/catch_test_macros.hpp>
#include <vector>

// index starts from 1
struct Fenwick {
  std::vector<int> tree;

  Fenwick(int n) : tree(n + 1, 0) {}

  Fenwick(std::vector<int> nums) : tree(nums.size() + 1, 0) {
    for (int i = 1; i < tree.size(); i++) {
      tree[i] += nums[i - 1];
      if (int j = i + (i & -i); j < tree.size()) {
        tree[j] += tree[i];
      }
    }
  }

  void update(int i, int delta) {
    for (int j = i; j < tree.size(); j += j & -j) {
      tree[j] += delta;
    }
  }

  int prefix_sum(int i) { // [1, i]
    int s = 0;
    for (int j = i; j > 0; j -= j & -j) {
      s += tree[j];
    }
    return s;
  }

  int range_sum(int i, int j) { // [i, j]
    return prefix_sum(j) - prefix_sum(i - 1);
  }
};

TEST_CASE("Fenwick", "[simple case]") {
  std::vector<int> v = {
      1, 3, 4, 6, 2, 6, 7, 9,
  };
  SECTION("Build from vector") {
    Fenwick t(v);
    REQUIRE(t.prefix_sum(4) == 14);
    REQUIRE(t.range_sum(2, 6) == 21);
    t.update(3, 5);
    REQUIRE(t.prefix_sum(4) == 19);
    REQUIRE(t.range_sum(2, 6) == 26);
  }

  SECTION("Build from iterator") {
    Fenwick t(v.size());
    for (int i = 1; i <= v.size(); i++) {
      t.update(i, v[i - 1]);
    }
    REQUIRE(t.prefix_sum(4) == 14);
    REQUIRE(t.range_sum(2, 6) == 21);
    t.update(3, 5);
    REQUIRE(t.prefix_sum(4) == 19);
    REQUIRE(t.range_sum(2, 6) == 26);
  }
}