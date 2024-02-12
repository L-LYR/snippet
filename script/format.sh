#!/bin/bash

find "$1" -type f -name "*.cc" \
    -o -name "*.hh" \
    -o -name "*.hpp" \
    -o -name "*.cpp" |
    xargs clang-format -i
