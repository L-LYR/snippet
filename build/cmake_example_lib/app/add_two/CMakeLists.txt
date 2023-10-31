set(sources main.cc)
add_executable(add2)
target_sources(add2 PRIVATE ${sources})
target_link_libraries(add2 PRIVATE ExampleLib::ExampleLib)