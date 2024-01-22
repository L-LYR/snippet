/*
 * @lc app=leetcode.cn id=31 lang=scala
 *
 * [31] 下一个排列
 */
package Q31

// @lc code=start
object Solution {
  def nextPermutation(nums: Array[Int]): Unit = {
    val s = nums.toList
    (s.zip(s.tail).lastIndexWhere(e => e._1 < e._2) match {
      case -1 => s.reverse
      case p => {
        val n = s.lastIndexWhere(s(p) < _)
        val (a, b) = s.updated(p, s(n)).updated(n, s(p)).splitAt(p + 1)
        a.concat(b.reverse)
      }
    }).zipWithIndex.foreach { case (x, i) => nums.update(i, x) }
  }
}
// @lc code=end
