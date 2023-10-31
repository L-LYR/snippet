#include <example_lib/example_lib.hh>

#include <iostream>

int main(int, char *[]) {
  auto sum = example_lib::add(1, 1);
  std::cout << sum << std::endl;
  return 0;
}