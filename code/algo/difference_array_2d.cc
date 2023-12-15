#include <algorithm>
#include <cassert>
#include <iomanip>
#include <iostream>
#include <vector>

struct DifferenceArray2D {
  std::vector<std::vector<int>> diff_arr;
  DifferenceArray2D(const std::vector<std::vector<int>> &origin) {
    diff_arr.resize(origin.size(), std::vector<int>(origin[0].size(), 0));
    for (int i = 0; i < origin[0].size(); i++) {
      diff_arr[0][i] = origin[0][i];
    }
    for (int j = 0; j < origin.size(); j++) {
      diff_arr[j][0] = origin[j][0];
    }
    for (int i = 1; i < origin.size(); i++) {
      for (int j = 1; j < origin[0].size(); j++) {
        diff_arr[i][j] = origin[i][j] - origin[i - 1][j] - origin[i][j - 1] +
                         origin[i - 1][j - 1];
      }
    }
  }
  // [(x1, y1), (x2, y2))
  void partial_add(int x1, int y1, int x2, int y2, int x) {
    diff_arr[x1][y1] += x;
    diff_arr[x1][y2] -= x;
    diff_arr[x2][y1] -= x;
    diff_arr[x2][y2] += x;
  }
  std::vector<std::vector<int>> get_origin() {
    std::vector<std::vector<int>> origin(
        diff_arr.size(), std::vector<int>(diff_arr[0].size(), 0));
    for (int i = 0; i < origin[0].size(); i++) {
      origin[0][i] = diff_arr[0][i];
    }
    for (int j = 0; j < origin.size(); j++) {
      origin[j][0] = diff_arr[j][0];
    }
    for (int i = 1; i < origin.size(); i++) {
      for (int j = 1; j < origin[0].size(); j++) {
        origin[i][j] = diff_arr[i][j] + origin[i - 1][j] + origin[i][j - 1] -
                       origin[i - 1][j - 1];
      }
    }
    return origin;
  }
  const std::vector<std::vector<int>> &underlying() { return diff_arr; }
};

int main() {
  std::vector<std::vector<int>> arr{
      {3, 5, 1, 5, 7, 8, 9, 4, 5, 2, 7}, {6, 3, 4, 5, 1, 2, 8, 9, 0, 1, 1},
      {7, 8, 4, 6, 2, 1, 6, 0, 9, 6, 8}, {1, 4, 4, 5, 2, 3, 4, 7, 9, 0, 6},
      {7, 7, 8, 4, 5, 2, 3, 0, 1, 2, 7}, {7, 7, 8, 8, 5, 5, 4, 4, 6, 0, 1},
      {0, 1, 6, 7, 4, 5, 4, 5, 8, 9, 0}, {6, 6, 7, 3, 4, 5, 8, 9, 0, 1, 2},
      {4, 5, 2, 1, 5, 6, 3, 7, 8, 9, 2}, {0, 6, 4, 5, 7, 7, 8, 3, 2, 5, 4},
      {8, 3, 6, 5, 9, 0, 1, 2, 3, 4, 5}, {9, 7, 5, 3, 5, 6, 3, 2, 4, 6, 7},
      {1, 3, 9, 2, 4, 5, 6, 7, 2, 3, 0},
  };
  DifferenceArray2D da(arr);
  int x1 = 4;
  int x2 = 7;
  int y1 = 6;
  int y2 = 10;
  int x = 5;
  auto print = [&](std::vector<std::vector<int>> a) {
    std::cout << std::setw(12) << "x\\y :";
    std::for_each(a[0].begin(), a[0].end(),
                  [i = 0](int) mutable { std::cout << std::setw(5) << i++; });
    std::cout << std::endl;
    for (int i = 0; i < a.size(); i++) {
      std::cout << std::setw(12) << std::to_string(i) + " :";
      std::for_each(a[i].begin(), a[i].end(), [&, j = 0](int x) mutable {
        if ((i >= x1 && j >= y1) && (i < x2 && j < y2)) {
          std::cout << std::setw(5) << "*" + std::to_string(x);
        } else {
          std::cout << std::setw(5) << x;
        }
        j++;
      });
      std::cout << std::endl;
    }
  };

  std::cout << "array :" << std::endl;
  print(arr);
  std::cout << "difference array :" << std::endl;
  print(da.underlying());
  std::cout << "add " << x << " for each [(" << x1 << ", " << y1 << "), (" << x2
            << ", " << y2 << "))" << std::endl;
  da.partial_add(x1, y1, x2, y2, x);
  std::cout << "updated difference array :" << std::endl;
  print(da.underlying());
  std::cout << "updated array :" << std::endl;
  print(da.get_origin());
  return 0;
}