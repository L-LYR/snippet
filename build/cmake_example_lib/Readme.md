# Example Lib For Learning CMake

```bash

mkdir tmp_install
cmake --preset debug -DCMAKE_INSTALL_PREFIX=$(readlink -f ./tmp_install)  # config
cmake --build build    # build
ctest --preset default # run tests
cmake --install build  # install

```
