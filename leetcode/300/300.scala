/*
 * @lc app=leetcode.cn id=300 lang=scala
 *
 * [300] 最长递增子序列
 */
package Q300

// @lc code=start
object Solution {
  def lengthOfLIS(nums: Array[Int]): Int = {
    val dp = Array.fill(nums.size)(1)
    for (i <- 0 until nums.size) {
      for (j <- 0 until i) {
        if (nums(i) > nums(j)) {
          dp(i) = math.max(dp(i), dp(j) + 1)
        }
      }
    }
    dp.max
  }
}
// @lc code=end
