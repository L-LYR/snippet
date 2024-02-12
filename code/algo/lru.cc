#include <list>
#include <unordered_map>

class LRUCache {
 public:
  int cap;
  std::list<std::pair<int, int>> slots;
  std::unordered_map<int, decltype(slots)::iterator> keyToSlot;

  LRUCache(int capacity) : cap(capacity) {}

  int get(int key) {
    if (auto iter = keyToSlot.find(key); iter != keyToSlot.end()) {
      auto value = iter->second->second;
      slots.erase(iter->second);
      slots.push_front({key, value});
      keyToSlot[key] = slots.begin();
      return value;
    }
    return -1;
  }

  void put(int key, int value) {
    if (auto iter = keyToSlot.find(key); iter != keyToSlot.end()) {
      slots.erase(iter->second);
    }
    if (slots.size() == cap) {
      keyToSlot.erase(slots.back().first);
      slots.pop_back();
    }
    slots.push_front({key, value});
    keyToSlot[key] = slots.begin();
  }
};