/*
 * @lc app=leetcode.cn id=918 lang=scala
 *
 * [918] 环形子数组的最大和
 */
package Q918

// @lc code=start
object Solution {
  def maxSubarraySumCircular(nums: Array[Int]): Int = {
    val s = nums.sum
    val max_s = nums.scanLeft(-1e5.toInt)((p, n) => n.max(p + n)).max
    val min_s = nums.scanLeft(1e5.toInt)((p, n) => n.min(p + n)).min
    if (min_s == s) max_s else max_s.max(s - min_s)
  }
}
// @lc code=end
