#include <algorithm>
#include <iomanip>
#include <iostream>
#include <vector>

struct DifferenceArray {
  std::vector<int> diff_arr;

  DifferenceArray(std::vector<int> origin) {
    diff_arr.resize(origin.size(), 0);
    diff_arr[0] = origin[0];
    for (int i = 1; i < origin.size(); i++) {
      diff_arr[i] = origin[i] - origin[i - 1];
    }
  }

  std::vector<int> get_origin() {
    std::vector<int> origin(diff_arr.size(), 0);
    origin[0] = diff_arr[0];
    for (int i = 1; i < diff_arr.size(); i++) {
      origin[i] = origin[i - 1] + diff_arr[i];
    }
    return origin;
  };

  // [l, r)
  void partial_add(int l, int r, int x) {
    diff_arr[l] += x;
    diff_arr[r] -= x;
  }

  const std::vector<int> &underlying() { return diff_arr; }
};

int main() {
  std::vector<int> arr = {
      4, 2, 3, 4, 6, 7, 8, 1, 0, 9, 2, 3, 3,
  };
  DifferenceArray da(arr);
  int l = 5;
  int r = 10;
  int x = 2;

  std::cout << std::setw(25) << "array:";
  std::for_each(arr.begin(), arr.end(),
                [](int x) { std::cout << std::setw(3) << x; });
  std::cout << std::endl;

  std::cout << std::setw(25) << "difference array:";
  std::for_each(da.underlying().begin(), da.underlying().end(),
                [](int x) { std::cout << std::setw(3) << x; });
  std::cout << std::endl;

  std::cout << std::setw(25) << "index:";
  std::for_each(arr.begin(), arr.end(),
                [i = 0](int) mutable { std::cout << std::setw(3) << i++; });
  std::cout << std::endl;

  std::cout << std::setw(25) << "location:";
  std::for_each(arr.begin(), arr.end(), [i = 0, l, r](int) mutable {
    std::cout << std::setw(3) << ((i >= l && i < r) ? "^" : " ");
    i++;
  });
  std::cout << std::endl;

  std::cout << "add " << x << " for each [" << l << ", " << r << ")"
            << std::endl;
  da.partial_add(l, r, x);
  std::cout << std::setw(25) << "updated difference array:";
  std::for_each(da.underlying().begin(), da.underlying().end(),
                [](int x) { std::cout << std::setw(3) << x; });
  std::cout << std::endl;
  auto updated = da.get_origin();
  std::cout << std::setw(25) << "updated array:";
  std::for_each(updated.begin(), updated.end(),
                [](int x) { std::cout << std::setw(3) << x; });
  std::cout << std::endl;

  return 0;
}