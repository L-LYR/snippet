#include <iomanip>
#include <iostream>
#include <queue>
#include <vector>

const constexpr static int inf = 0x3f3f3f3f;

std::vector<std::vector<int>>
floyd(const std::vector<std::vector<int>> &g_mat) {
  int n = g_mat.size();
  auto distance = g_mat;
  for (int k = 0; k < n; k++) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        distance[i][j] =
            std::min(distance[i][j], distance[i][k] + distance[k][j]);
      }
    }
  }
  return distance;
};

using node_t = std::pair<int, int>; // <distance, target>
std::vector<std::vector<int>>
dijkstra(const std::vector<std::vector<node_t>> &g_adj) {
  int n = g_adj.size();
  std::vector<std::vector<int>> distance(n, std::vector<int>(n, inf));
  auto fn = [&](int s) {
    std::priority_queue<node_t, std::vector<node_t>, std::greater<node_t>> q;
    std::vector<bool> visited(n, false);
    distance[s][s] = 0;
    q.emplace(0, s);
    while (!q.empty()) {
      auto [_, u] = q.top();
      q.pop();
      if (visited[u]) {
        continue;
      } else {
        visited[u] = true;
      }
      for (auto &[d, v] : g_adj[u]) {
        if (distance[s][v] > distance[s][u] + d) {
          distance[s][v] = distance[s][u] + d;
          q.emplace(distance[s][v], v);
        }
      }
    }
  };
  for (int i = 0; i < n; i++) {
    fn(i);
  }
  return distance;
}

int main() {
  int n = 7;
  std::vector<std::tuple<int, int, int>> edges = {
      {0, 1, 12}, {5, 0, 16}, {6, 0, 14}, {1, 5, 7}, {2, 1, 10}, {2, 3, 3},
      {2, 4, 5},  {5, 2, 6},  {4, 3, 4},  {4, 5, 2}, {4, 6, 8},  {5, 6, 9},
  };
  std::vector<std::vector<node_t>> g_adj(n);
  std::vector<std::vector<int>> g_mat(n, std::vector<int>(n, inf));

  std::vector<std::vector<node_t>> dg_adj(n);
  std::vector<std::vector<int>> dg_mat(n, std::vector<int>(n, inf));

  for (int i = 0; i < n; i++) {
    g_mat[i][i] = 0;
    dg_mat[i][i] = 0;
  }

  for (auto &[v, u, w] : edges) {
    g_adj[v].emplace_back(w, u);
    g_adj[u].emplace_back(w, v);
    g_mat[v][u] = w;
    g_mat[u][v] = w;
    dg_adj[v].emplace_back(w, u);
    dg_mat[v][u] = w;
  }

  auto g_floyd_res = floyd(g_mat);
  auto dg_floyd_res = floyd(dg_mat);
  auto g_dijkstra_res = dijkstra(g_adj);
  auto dg_dijkstra_res = dijkstra(dg_adj);

  auto print = [&](std::vector<std::vector<int>> a) {
    std::cout << std::setw(12) << "x\\y :";
    std::for_each(a[0].begin(), a[0].end(),
                  [i = 0](int) mutable { std::cout << std::setw(3) << i++; });
    std::cout << std::endl;
    for (int i = 0; i < a.size(); i++) {
      std::cout << std::setw(12) << std::to_string(i) + " :";
      std::for_each(a[i].begin(), a[i].end(), [&](int x) mutable {
        if (x == inf) {
          std::cout << std::setw(3) << -1;
        } else {
          std::cout << std::setw(3) << x;
        }
      });
      std::cout << std::endl;
    }
  };
  print(g_floyd_res);
  print(dg_floyd_res);
  print(g_dijkstra_res);
  print(dg_dijkstra_res);
  return 0;
}