/*
 * @lc app=leetcode.cn id=198 lang=scala
 *
 * [198] 打家劫舍
 */
package Q198

// @lc code=start
object Solution {
  def rob(nums: Array[Int]): Int = {
    if (nums.size == 1) {
      nums(0)
    } else {
      nums
        .drop(2)
        .foldLeft((nums(0), math.max(nums(0), nums(1)))) { case ((pp, p), x) =>
          (p, math.max(x + pp, p))
        }
        ._2
    }
  }
}
// @lc code=end
