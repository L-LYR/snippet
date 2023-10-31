find_package(Catch2 QUIET)

if(NOT Catch2_FOUND)
  include(FetchContent)
  FetchContent_Declare(
    Catch2
    GIT_REPOSITORY https://github.com/catchorg/Catch2.git
    GIT_TAG v3.0.1
  )
  FetchContent_MakeAvailable(Catch2)
  list(APPEND CMAKE_MODULE_PATH ${catch2_SOURCE_DIR}/extras)

  # Reference: https://github.com/catchorg/Catch2/blob/devel/docs/cmake-integration.md
endif()

set(
  sources
  example_lib_test.cc
)

add_executable(ExampleLibTests)
target_sources(ExampleLibTests PRIVATE ${sources})

target_link_libraries(
  ExampleLibTests
  PRIVATE
  ExampleLib::ExampleLib
  Catch2::Catch2WithMain
)

include(CTest)
include(Catch)
catch_discover_tests(ExampleLibTests)