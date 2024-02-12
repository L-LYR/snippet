#include <dbg.h>

#include <iostream>
#include <queue>
#include <vector>

int main() {
  int n = 6;
  std::vector<std::pair<int, int>> edges = {
      {5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1},
  };

  std::vector<std::vector<int>> g;
  std::vector<int> in;
  g.resize(n);
  in.resize(n, 0);
  for (auto [u, v] : edges) {
    g[u].push_back(v);
    in[v]++;
  }

  std::queue<int> q;
  for (int i = 0; i < n; i++) {
    if (in[i] == 0) {
      q.push(i);
    }
  }

  std::vector<int> result;
  result.reserve(n);
  while (not q.empty()) {
    int v = q.front();
    q.pop();
    result.push_back(v);
    for (int u : g[v]) {
      if (--in[u] == 0) {
        q.push(u);
      }
    }
  }
  if (result.size() != 0) {
    return -1;
  }
  return 0;
}