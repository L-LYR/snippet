/*
 * @lc app=leetcode.cn id=2336 lang=scala
 *
 * [2336] 无限集中的最小数字
 */
package Q2336

// @lc code=start
class SmallestInfiniteSet() {
  import scala.collection.mutable.SortedSet
  val s = SortedSet.empty[Int]
  var lim = 1

  def popSmallest(): Int = {
    if (s.isEmpty) {
      val v = lim
      lim = lim + 1
      v
    } else {
      val v = s.head
      s.remove(v)
      v
    }
  }

  def addBack(num: Int): Unit = {
    if (num + 1 == lim) {
      lim = lim - 1
      s.remove(num)
    } else if (num < lim && !s.contains(num)) {
      s.add(num)
    }
  }

}
// @lc code=end
