#include <list>
#include <optional>
#include <tuple>
#include <unordered_map>

class LFUCache {
  using Slots = std::list<std::tuple<int, int, int>>;
  int capacity;
  int minFreq;
  std::unordered_map<int, Slots> freqToSlots;
  std::unordered_map<int, Slots::iterator> keyToSlot;

 private:
  std::optional<Slots::iterator> getSlot(int key) {
    if (auto slot = keyToSlot.find(key); slot != keyToSlot.end()) {
      auto &[_, value, freq] = *(slot->second);
      auto &curFreqSlots = freqToSlots[freq + 1];
      curFreqSlots.splice(curFreqSlots.end(), freqToSlots[freq], slot->second);
      if (minFreq == freq && freqToSlots[minFreq].empty()) {
        minFreq++;
      }
      freq++;
      return slot->second;
    }
    return std::nullopt;
  }

 public:
  LFUCache(int capacity) : capacity(capacity), minFreq(0) {}

  int get(int key) {
    if (auto opt = getSlot(key)) {
      return get<1>(*opt.value());
    } else {
      return -1;
    }
  }

  void put(int key, int value) {
    if (auto opt = getSlot(key)) {
      get<1>(*opt.value()) = value;
      return;
    }
    if (capacity == keyToSlot.size()) {
      auto &minFreqSlots = freqToSlots[minFreq];
      auto keyToEvict = get<0>(minFreqSlots.front());
      keyToSlot.erase(keyToEvict);
      minFreqSlots.pop_front();
    }
    minFreq = 1;
    auto &minFreqSlots = freqToSlots[minFreq];
    keyToSlot[key] = minFreqSlots.emplace(minFreqSlots.end(), key, value, 1);
  }
};
