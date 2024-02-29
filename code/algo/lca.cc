#include <catch2/catch_test_macros.hpp>
#include <functional>
#include <vector>

struct LCA {
  int m;
  int n;
  std::vector<std::vector<int>> graph;
  std::vector<std::vector<int>> ancestors;
  std::vector<int> depth;

  LCA(int n, std::vector<std::pair<int, int>> edges, int root)
      : n(n), m(32 - std::countl_zero(1u * n)), graph(n),
        ancestors(n, std::vector<int>(m, -1)), depth(n, 0) {
    for (const auto &[u, v] : edges) {
      graph[u].push_back(v);
      graph[v].push_back(u);
    }
    std::function<void(int, int)> dfs = [&](int x, int father) -> void {
      ancestors[x][0] = father;
      for (auto y : graph[x]) {
        if (y == father) {
          continue;
        }
        depth[y] = depth[x] + 1;
        dfs(y, x);
      }
    };
    dfs(root, -1);

    for (int i = 0; i < m - 1; i++) {
      for (int x = 0; x < n; x++) {
        int ancestor = ancestors[x][i];
        if (ancestor != -1) {
          ancestors[x][i + 1] = ancestors[ancestor][i];
        }
      }
    }
  }

  int get_kth_ancestor_of(int x, int k) {
    for (int i = 0; i < 32 - std::countl_zero(1u * k); i++) {
      if ((k >> i) & 1) {
        x = ancestors[x][i];
        if (x < 0) {
          break;
        }
      }
    }
    return x;
  }

  int query_lca_of(int p, int q) {
    if (depth[p] > depth[q]) {
      return query_lca_of(q, p);
    }
    q = get_kth_ancestor_of(q, depth[q] - depth[p]);
    if (p == q) {
      return p;
    }
    for (int i = m - 1; i >= 0; i--) {
      if (ancestors[p][i] != ancestors[q][i]) {
        p = ancestors[p][i];
        q = ancestors[q][i];
      }
    }
    return ancestors[p][0];
  }
};

TEST_CASE("Lowest Common Ancestor", "[simple case]") {
  auto edges = std::vector<std::pair<int, int>>{{1, 2}, {1, 3}, {2, 4}, {2, 5},
                                                {3, 6}, {3, 0}, {0, 7}};
  auto lca = LCA(8, edges, 1);

  REQUIRE(lca.get_kth_ancestor_of(7, 2) == 3);
  REQUIRE(lca.get_kth_ancestor_of(1, 1) == -1);
  REQUIRE(lca.query_lca_of(4, 2) == 2);
  REQUIRE(lca.query_lca_of(4, 6) == 1);
}