/*
 * @lc app=leetcode.cn id=57 lang=scala
 *
 * [57] 插入区间
 */
package Q57

// @lc code=start
object Solution {
  def insert(
      intervals: Array[Array[Int]],
      newInterval: Array[Int]
  ): Array[Array[Int]] = {
    val (left, rest) = intervals.span(p => p(1) < newInterval(0))
    val (needMerge, right) = rest.span(p => p(0) <= newInterval(1))
    val i = needMerge.foldLeft(newInterval) {
      case (Array(l, r), Array(ll, rr)) =>
        Array(l min ll, r max rr)
    }
    left ++ Array(i) ++ right
  }
}
// @lc code=end
