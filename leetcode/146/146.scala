/*
 * @lc app=leetcode.cn id=146 lang=scala
 *
 * [146] LRU 缓存
 */
package Q146

// @lc code=start
class LRUCache(_capacity: Int) {

  case class Slot(value: Int)

  val cache = new scala.collection.mutable.LinkedHashMap[Int, Slot]()

  def get(key: Int): Int = cache
    .get(key)
    .map(slot => {
      cache.remove(key)
      cache.put(key, slot)
      slot.value
    })
    .getOrElse(-1)

  def put(key: Int, value: Int) {
    if (cache.contains(key)) {
      cache.remove(key)
    } else if (cache.size == _capacity) {
      cache.remove(cache.head._1)
    }
    cache.put(key, Slot(value))
  }
}

/** Your LRUCache object will be instantiated and called as such: var obj = new
  * LRUCache(capacity) var param_1 = obj.get(key) obj.put(key,value)
  */
// @lc code=end
