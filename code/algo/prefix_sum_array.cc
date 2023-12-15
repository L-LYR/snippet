#include <algorithm>
#include <cassert>
#include <iomanip>
#include <iostream>
#include <vector>

struct PrefixSumArray {
  std::vector<int> prefix_sum;

  PrefixSumArray(const std::vector<int> &origin) {
    prefix_sum.resize(origin.size() + 1, 0);
    for (int i = 1; i <= origin.size(); i++) {
      prefix_sum[i] = prefix_sum[i - 1] + origin[i - 1];
    }
  }

  // [l, r)
  int partial_sum(int l, int r) { return prefix_sum[r] - prefix_sum[l]; }

  const std::vector<int> &underlying() { return prefix_sum; }
};

int main() {
  std::vector<int> arr = {
      4, 2, 3, 4, 6, 7, 8, 1, 0, 9, 2, 3, 3,
  };
  PrefixSumArray ps(arr);
  int l = 5;
  int r = 10;

  std::cout << std::setw(12) << "array:";
  std::for_each(arr.begin(), arr.end(),
                [](int x) { std::cout << std::setw(3) << x; });
  std::cout << std::endl;

  std::cout << std::setw(12) << "prefix sum:";
  std::for_each(ps.underlying().begin(), ps.underlying().end(),
                [](int x) { std::cout << std::setw(3) << x; });
  std::cout << std::endl;

  std::cout << std::setw(12) << "index:";
  std::for_each(arr.begin(), arr.end(),
                [i = 0](int) mutable { std::cout << std::setw(3) << i++; });
  std::cout << std::endl;

  std::cout << std::setw(12) << "location:";
  std::for_each(arr.begin(), arr.end(), [i = 0, l, r](int) mutable {
    std::cout << std::setw(3) << ((i >= l && i < r) ? "^" : " ");
    i++;
  });
  std::cout << std::endl;

  std::cout << "sum of subarray[" << l << ", " << r
            << ") = " << ps.partial_sum(l, r) << std::endl;
  return 0;
}