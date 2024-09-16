#include <algorithm>
#include <fstream>
#include <iterator>
#include <string>
#include <unordered_map>
#include <vector>

namespace q2 {

void solution(std::fstream&& in, std::fstream&& out) {
  auto begin_pos = in.tellg();
  // part1
  {
    std::string s;
    int two = 0;
    int three = 0;
    while (!in.eof()) {
      in >> s;
      std::unordered_map<char, int> count;
      std::ranges::for_each(s, [&](char c) { count[c]++; });
      if (std::ranges::any_of(count, [&](auto&& p) { return p.second == 2; })) {
        two++;
      }
      if (std::ranges::any_of(count, [&](auto&& p) { return p.second == 3; })) {
        three++;
      }
    }
    out << two * three << std::endl;
  }
  in.seekg(begin_pos);
  // part2
  {
    std::vector<std::string> ids;
    std::copy(std::istream_iterator<std::string>(in),
              std::istream_iterator<std::string>(), std::back_inserter(ids));
    for (auto i = 0uz; i < ids.size(); i++) {
      for (auto j = i + 1; j < ids.size(); j++) {
        auto count = 0uz;
        auto idx = 0uz;
        for (auto k = 0uz; k < ids[i].size(); k++) {
          if (ids[i][k] != ids[j][k]) {
            count++;
            idx = k;
          }
        }
        if (count == 1) {
          out << ids[i].substr(0, idx) << ids[i].substr(idx + 1) << std::endl;
        }
      }
    }
  }
}

}  // namespace q2
