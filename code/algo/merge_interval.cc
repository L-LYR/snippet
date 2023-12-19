#include <iostream>
#include <map>

struct Intervals {
  std::map<int, int> intervals;

  void add(const std::pair<int, int> &interval) {
    add(interval.first, interval.second);
  }

  void add(int left, int right) {
    // to merge [x, y] [y + 1, z] into [x, z]
    auto iter = intervals.lower_bound(left - 1);
    // auto iter = intervals.lower_bound(left);
    // not to merge [x, y] [y + 1, z] into [x, z]
    while (iter != intervals.end()) {
      if (iter->second > right) {
        break;
      }
      left = std::min(iter->second, left);
      right = std::max(iter->first, right);
      iter = intervals.erase(iter);
    }
    intervals.emplace(right, left);
  }

  std::vector<std::pair<int, int>> get() {
    std::vector<std::pair<int, int>> result;
    result.reserve(intervals.size());
    std::transform(intervals.begin(), intervals.end(),
                   std::back_inserter(result),
                   [](const decltype(intervals)::value_type &e) {
                     return std::make_pair(e.second, e.first);
                   });
    return result;
  }
};

int main() {
  std::vector<std::pair<int, int>> intervals = {
      {2, 4}, {6, 7}, {11, 19}, {21, 25}, {26, 28},
  };
  Intervals is;
  for (const auto &i : intervals) {
    is.add(i);
  }
  auto print = [](const std::vector<std::pair<int, int>> &is) {
    std::cout << "intervals:";
    for (auto &i : is) {
      std::cout << " [" << i.first << ", " << i.second << "]";
    }
    std::cout << std::endl;
  };
  print(is.get());
  is.add(5, 10);
  print(is.get());
  return 0;
}