if(EXAMPLE_LIB_BUILD_AS_SHARED)
    add_library(ExampleLib SHARED)
else()
    add_library(ExampleLib STATIC)
endif()

add_library(ExampleLib::ExampleLib ALIAS ExampleLib)

set(
    sources
    example_lib.cc
)
set(
    public_headers
    ${PROJECT_SOURCE_DIR}/include/example_lib/example_lib.hh
)

target_sources(ExampleLib PRIVATE ${sources})

target_include_directories(
    ExampleLib
    PUBLIC
    $<BUILD_INTERFACE:${PROJECT_SOURCE_DIR}/include>
)

set_target_properties(
    ExampleLib PROPERTIES
    SOVERSION ${PROJECT_VERSION_MAJOR}
    VERSION ${PROJECT_VERSION}
    PUBLIC_HEADER ${public_headers}
)