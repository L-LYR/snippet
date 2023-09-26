#include <vector>

class DisjointSetUnion {
  std::vector<int> parent;
  std::vector<int> rank;
  std::vector<int> size;

public:
  DisjointSetUnion(int n) : parent(n + 1), rank(n + 1), size(n + 1) {
    for (int i = 1; i <= n; i++) {
      parent[i] = i;
      rank[i] = 0;
      size[i] = 1;
    }
  }

  int find(int x) {
    if (parent[x] != x) {
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }

  void merge(int u, int v) {
    u = find(u);
    v = find(v);
    if (rank[u] < rank[v]) {
      parent[u] = v;
      size[v] += size[u];
    } else if (rank[u] > rank[v]) {
      parent[v] = u;
      size[u] += size[v];
    } else {
      rank[u]++;
      parent[v] = u;
      size[u] += size[v];
    }
  }

  bool connected(int u, int v) { return find(u) == find(v); }
};