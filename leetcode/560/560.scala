/*
 * @lc app=leetcode.cn id=560 lang=scala
 *
 * [560] 和为 K 的子数组
 */
package Q560

// @lc code=start
object Solution {
  def subarraySum(nums: Array[Int], k: Int): Int = {
    nums.foldLeft((Map(0 -> 1), 0, 0)) {
      case ((m, s, acc), x) => {
        val ns = s + x
        val nacc = acc + m.getOrElse(ns - k, 0)
        val nm = m.updatedWith(ns) {
          case None    => Some(1)
          case Some(v) => Some(v + 1)
        }
        (nm, ns, nacc)
      }
    }._3
  }
}
// @lc code=end
