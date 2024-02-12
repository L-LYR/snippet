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

#include <functional>
std::vector<int> find(std::string_view source, std::string_view target) {
  int n = target.size();

  srand(time(0));
  int mod = 998244353 + rand() % 10007;
  int base = 33 + rand() % 233;

  long long power[n + 1];
  power[0] = 1;
  for (int i = 1; i <= n; i++) {
    power[i] = power[i - 1] * base % mod;
  }

  long long h[n + 1];
  h[0] = 0;
  for (int i = 1; i <= n; i++) {
    h[i] = (h[i - 1] * base + target[i - 1] - 'a') % mod;
  }

  auto query = [&](int l, int r) {
    return (h[r] - h[l - 1] * power[r - l + 1] % mod + mod) % mod;
  };
}
