#include <catch2/catch_test_macros.hpp>
#include <iostream>
#include <vector>

auto generate_p(std::string_view &&txt) -> std::vector<int> {
  auto p = std::vector<int>(txt.size(), 0);
  for (int i = 1; i < txt.size(); i++) {
    int j = p[i - 1];
    while (j > 0 && txt[i] != txt[j]) {
      j = p[j - 1];
    }
    if (txt[i] == txt[j]) {
      j++;
    }
    p[i] = j;
  }
  return p;
}

auto match(std::string_view txt, std::string_view pat, char sep)
    -> std::vector<int> {
  auto new_text = std::string();
  new_text.reserve(txt.size() + pat.size() + 1);
  new_text.append(pat);
  new_text.push_back(sep);
  new_text.append(txt);
  auto p = generate_p(new_text);

  auto result = std::vector<int>();
  for (auto i = pat.size() + 1; i < new_text.size(); i++) {
    if (p[i] == pat.size()) {
      result.push_back(i - 2 * pat.size());
    }
  }
  return result;
}

TEST_CASE("Match With P", "normal case") {
  auto text = "abababzabababab";
  auto pattern = "aba";
  auto z = match(std::string_view(text), std::string_view(pattern), '#');
  REQUIRE(z == std::vector<int>{0, 2, 7, 9, 11});
}