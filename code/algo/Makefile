.PHONY:
	clean main

TARGET_NAME = main

CXX = clang++
CXX_INCLUDE_PATH =
CXX_FLAGS = -std=c++2a
CXX_LINK_PATH =

# add catch2 with main
CXX_INCLUDE_PATH += $(shell pkg-config --cflags catch2-with-main)
CXX_LINK_PATH += $(shell pkg-config --libs catch2-with-main)

# add ranges
CXX_INCLUDE_PATH += -I$(RANGES_V3_PATH)

$(TARGET_NAME): $(what).cc
	$(CXX) $(CXX_FLAGS) $(CXX_INCLUDE_PATH) $^ $(CXX_LINK_PATH) -o $@

clean:
	rm $(TARGET_NAME)