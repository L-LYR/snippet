#include <fstream>

#define ApplyForAllSolution(M) \
  M(1)                         \
  M(2)

#define Define(n)                                                \
  namespace q##n {                                               \
    extern void solution(std::fstream&& in, std::fstream&& out); \
  }

#define Run(n)                                                    \
  q##n::solution(                                                 \
      std::fstream("../../aoc/aoc.2018." #n ".in", std::ios::in), \
      std::fstream("../../aoc/aoc.2018." #n ".cpp.out", std::ios::out));

ApplyForAllSolution(Define);

int main() {
  ApplyForAllSolution(Run);
  return 0;
}