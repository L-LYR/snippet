#include <algorithm>
#include <iostream>

void gospers_hack(int k, int n) {
  int cur = (1 << k) - 1;
  int limit = (1 << n);
  while (cur < limit) {

    std::cout << std::bitset<5>(cur) << std::endl;

    int lb = cur & -cur;
    int r = cur + lb;
    cur = (((r ^ cur) >> 2) / lb) | r;
  }
}

void show_permutation(int k, int n) {
  std::string s = std::string(n - k, '0') + std::string(k, '1');
  do {
    std::cout << s << std::endl;
  } while (std::next_permutation(s.begin(), s.end()));
}

int main() {

  gospers_hack(3, 5);

  std::cout << std::endl;

  show_permutation(3, 5);

  return 0;
}

