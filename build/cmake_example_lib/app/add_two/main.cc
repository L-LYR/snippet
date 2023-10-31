#include <example_lib/example_lib.hh>

#include <iostream>

int main(int argc, char *argv[]) {
  if (argc != 2) {
    return -1;
  }
  std::cout << example_lib::add(std::atoi(argv[1]), 2) << std::endl;
  return 0;
}