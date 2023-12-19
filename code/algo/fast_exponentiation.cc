#include <iostream>

int fast_exp_rec(int x, int p) {
  if (p == 0) {
    return 1;
  } else {
    auto r = fast_exp_rec(x, p / 2);
    return (p % 2 == 0) ? (r * r) : (r * r * x);
  }
}

int fast_exp_mod_rec(int x, int p, int m) {
  if (p == 0) {
    return 1;
  } else {
    auto r = fast_exp_mod_rec(x, p / 2, m);
    return (p % 2 == 0) ? (r * r % m) : ((r * r % m) * (x % m) % m);
  }
}

int fast_exp(int x, int p) {
  int r = 1;
  while (p > 0) {
    if (p % 2 == 1) {
      r *= x;
    }
    x *= x;
    p /= 2;
  }
  return r;
}

int fast_exp_mod(int x, int p, int m) {
  int r = 1;
  while (p > 0) {
    if (p % 2 == 1) {
      r = r * x % m;
    }
    x = x * x % m;
    p /= 2;
  }
  return r;
}

int main() {
  std::cout << "non-recursive:" << std::endl;
  std::cout << "6 ^ 7 = " << fast_exp(6, 7) << std::endl;
  std::cout << "6 ^ 7 % 7 = " << fast_exp_mod(6, 7, 7) << std::endl;
  std::cout << "recursive:" << std::endl;
  std::cout << "6 ^ 7 = " << fast_exp_rec(6, 7) << std::endl;
  std::cout << "6 ^ 7 % 7 = " << fast_exp_mod_rec(6, 7, 7) << std::endl;
  return 0;
}