/*
 * @lc app=leetcode.cn id=53 lang=scala
 *
 * [53] 最大子数组和
 */
package Q53

// @lc code=start
object Solution {
  def maxSubArray(nums: Array[Int]): Int = {
    nums.scanLeft(-1e5.toInt)((p, n) => n.max(p + n)).max
  }
}
// @lc code=end
