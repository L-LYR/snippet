#include <string>
#include <string_view>

std::vector<std::string_view> split(std::string_view sv, std::string sep) {
  std::vector<std::string_view> tokens;
  auto begin_pos = sv.find_first_not_of(sep, 0);
  auto end_pos = sv.find_first_of(sep, begin_pos);
  while (begin_pos != std::string_view::npos ||
         end_pos != std::string_view::npos) {
    tokens.push_back(sv.substr(begin_pos, end_pos - begin_pos));
    begin_pos = sv.find_first_not_of(sep, end_pos);
    end_pos = sv.find_first_of(sep, begin_pos);
  }
  return tokens;
}