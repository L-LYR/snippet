#include "example_lib/example_lib.hh"
#include <catch2/catch_test_macros.hpp>

TEST_CASE("test example lib", "[add]") {
  REQUIRE(example_lib::add(1, 1) == 2);
  REQUIRE(example_lib::add(1, example_lib::add(1, 1)) == 3);
}