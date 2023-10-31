cmake_minimum_required(VERSION 3.19)

# detect if this lib is bundled
if(NOT DEFINED PROJECT_NAME)
  set(IS_SUBPROJECT OFF)
else()
  set(IS_SUBPROJECT ON)
endif()

project(
    ExampleLib
    VERSION 1.0.0
    DESCRIPTION "Template for C++ library built with CMake"
    LANGUAGES CXX
)

message(STATUS ${PROJECT_SOURCE_DIR})
list(APPEND CMAKE_MODULE_PATH ${PROJECT_SOURCE_DIR}/cmake/)
include(ConfigSafeGuards)

option(EXAMPLE_LIB_BUILD_TESTS "build tests" OFF)
option(EXAMPLE_LIB_BUILD_APPS "build apps" OFF)
option(EXAMPLE_LIB_BUILD_EXAMPLES "build examples" OFF)
option(EXAMPLE_LIB_BUILD_AS_SHARED "build as shared library" ON)

add_subdirectory("src")

if(EXAMPLE_LIB_BUILD_APPS)
    add_subdirectory("app")
endif()

if(EXAMPLE_LIB_BUILD_TESTS)
    enable_testing()
    add_subdirectory("tests")
endif()

if(EXAMPLE_LIB_BUILD_EXAMPLES)
    add_subdirectory("examples")
endif()

if(NOT IS_SUBPROJECT)
    include(GNUInstallDirs)
    install(
        TARGETS ExampleLib
        EXPORT ExampleLibTargets
        LIBRARY DESTINATION lib
        ARCHIVE DESTINATION lib
        RUNTIME DESTINATION bin
        PUBLIC_HEADER DESTINATION include
    )

    include(CMakePackageConfigHelpers)
    write_basic_package_version_file(
        ExampleLibConfigVersion.cmake
        VERSION ${PROJECT_VERSION}
        COMPATIBILITY AnyNewerVersion
    )

    install(
        EXPORT ExampleLibTargets
        FILE ExampleLibTargets.cmake
        NAMESPACE ExampleLib::
        DESTINATION lib/cmake/examplelib
    )

    configure_file(${PROJECT_SOURCE_DIR}/cmake/ExampleLibConfig.cmake.in ExampleLibConfig.cmake @ONLY)
    install(
        FILES
        "${PROJECT_BINARY_DIR}/ExampleLibConfig.cmake"
        "${PROJECT_BINARY_DIR}/ExampleLibConfigVersion.cmake"
        DESTINATION lib/cmake/examplelib
    )
endif()