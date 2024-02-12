#include <algorithm>
#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
#include <vector>

std::unordered_map<char, int> op2prio = {
    {'+', 1}, {'-', 1}, {'*', 2}, {'/', 2}, {'%', 2}, {'^', 3},
};

int eval(std::string_view sv) {
  std::stack<int> opds;
  std::stack<int> ops;
  auto do_calc = [&]() {
    if (opds.size() < 2 || ops.empty()) {
      return;
    }
    int right = opds.top();
    opds.pop();
    int left = opds.top();
    opds.pop();
    char op = ops.top();
    ops.pop();
    int result = 0;
    switch (op) {
      case '+': {
        result = left + right;
      } break;
      case '-': {
        result = left - right;
      } break;
      case '*': {
        result = left * right;
      } break;
      case '/': {
        result = left / right;
      } break;
      case '%': {
        result = left % right;
      } break;
      case '^': {
        result = std::pow(left, right);
      } break;
      default: {
      } break;
    }
    std::cout << left << op << right << "=" << result << std::endl;
    opds.push(result);
  };
  opds.emplace(0);
  int x = 0;
  bool has_opd = false;
  for (auto c : sv) {
    switch (c) {
      case '(': {
        ops.push(c);
      } break;
      case ')': {
        if (has_opd) {
          opds.push(x);
          x = 0;
          has_opd = false;
        }
        while (!ops.empty()) {
          if (ops.top() != '(') {
            do_calc();
          } else {
            ops.pop();
            break;
          }
        }
      } break;
      default: {
        if (std::isdigit(c)) {
          x = x * 10 + (c - '0');
          has_opd = true;
        } else if (std::isspace(c)) {
          continue;
        } else {
          if (has_opd) {
            opds.push(x);
            x = 0;
            has_opd = false;
          }
          while (!ops.empty() && ops.top() != '(') {
            char prev_op = ops.top();
            if (op2prio[prev_op] >= op2prio[c]) {
              do_calc();
            } else {
              break;
            }
          }
          ops.push(c);
        }
      } break;
    }
  }
  while (!ops.empty()) {
    do_calc();
  }
  return opds.top();
}

int eval(const std::string &s) { return eval(std::string_view(s)); }

int main() {
  auto eq =
      std::string("1 + 4 * 6 - (8 / 2^2 + (4 * 4) - 8 * 9 + (9 - 6 / 2))");
  std::cout << eval(eq) << std::endl;
  return 0;
}