#include <iostream>
#include <string>

template <size_t Depth = 1'000'000, size_t Width = 255> struct Trie {
  int node[Depth][Width];
  int count;
  bool exist[Depth];

  void insert(std::string_view s) {
    int p = 0;
    for (auto c : s) {
      if (!node[p][c]) {
        node[p][c] = ++count;
      }
      p = node[p][c];
    }
    exist[p] = 1;
  }

  bool find(std::string_view s) {
    int p = 0;
    for (auto c : s) {
      if (!node[p][c]) {
        return 0;
      }
      p = node[p][c];
    }
    return exist[p];
  }
};