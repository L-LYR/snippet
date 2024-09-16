#include <fstream>
#include <iterator>
#include <unordered_set>
#include <vector>

namespace q1 {

void solution(std::fstream&& in, std::fstream&& out) {
  auto begin_pos = in.tellg();
  // part1
  {
    int32_t freq = 0;
    int32_t value = 0;
    while (!in.eof()) {
      in >> value;
      freq += value;
    }
    out << freq << std::endl;
  }
  // part2
  in.seekg(begin_pos);
  {
    std::vector<int32_t> seq;
    std::copy(std::istream_iterator<int32_t>(in),
              std::istream_iterator<int32_t>(), std::back_inserter(seq));
    std::unordered_set<int64_t> freq_met;
    int64_t freq = 0;
    for (auto i = 0uz; freq_met.insert(freq).second;
         i = (i + 1 >= seq.size() ? 0 : i + 1)) {
      freq += seq[i];
    }
    out << freq << std::endl;
  }
}

}  // namespace q1
