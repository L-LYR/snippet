set(sources main.cc)
add_executable(add)
target_sources(add PRIVATE ${sources})
target_link_libraries(add PRIVATE ExampleLib::ExampleLib)