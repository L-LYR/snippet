#include <fstream>
#include <iostream>

int main() {
  std::fstream in("aoc/aoc.2018.1.in", std::ios::in);
  std::fstream out("aoc/aoc.2018.1.cpp.out", std::ios::out);

  int32_t freq = 0;
  int32_t value = 0;
  while (!in.eof()) {
    in >> value;
    freq += value;
  }
  out << freq << std::endl;

  return 0;
}