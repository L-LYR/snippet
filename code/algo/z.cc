#include <catch2/catch_test_macros.hpp>
#include <iostream>
#include <string_view>
#include <vector>

// #include <range/v3/view.hpp>

auto generate_z(std::string_view &&txt) -> std::vector<int> {
  auto z = std::vector<int>(txt.size(), 0);
  for (auto i = 1, l = 0, r = 0; i < txt.size(); i++) { // [l, r]
    auto &j = z[i];
    j = std::max(0, std::min(z[i - l], r - i + 1));
    while (i + j < txt.size() && txt[j] == txt[i + j]) {
      l = i;
      r = i + j;
      j++;
    }
  }
  return z;
}

TEST_CASE("Generate Z", "normal case") {
  auto text = "abababzabababab";
  auto z = generate_z(std::string_view(text));
  REQUIRE(z == std::vector<int>{0, 0, 4, 0, 2, 0, 0, 6, 0, 6, 0, 4, 0, 2, 0});
}

auto match(std::string_view txt, std::string_view pat, char sep)
    -> std::vector<int> {
  // namespace r = ranges;
  // namespace rv = ranges::views;
  // auto new_text = rv::concat(p, std::string_view(&sep), t);
  auto new_text = std::string();
  new_text.reserve(txt.size() + pat.size() + 1);
  new_text.append(pat);
  new_text.push_back(sep);
  new_text.append(txt);
  auto z = generate_z(new_text);

  auto result = std::vector<int>();
  for (int i = 0; i < txt.size(); i++) {
    if (z[i + pat.size() + 1] == pat.size()) {
      result.push_back(i);
    }
  }
  return result;

  // return rv::ints(0, (int)t.size()) | rv::for_each([&](auto i) {
  //          return r::yield_if(z[i + p.size() + 1] == p.size(), i - p.size());
  //        }) |
  //        r::to<std::vector<int>>();
}

TEST_CASE("Match With Z", "normal case") {
  auto text = "abababzabababab";
  auto pattern = "aba";
  auto result = match(std::string_view(text), std::string_view(pattern), '#');
  REQUIRE(result == std::vector<int>{0, 2, 7, 9, 11});
}