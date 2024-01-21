/*
 * @lc app=leetcode.cn id=45 lang=scala
 *
 * [45] 跳跃游戏 II
 */
package Q45

// @lc code=start
object Solution {
  def jump(nums: Array[Int]): Int = {
    val dp = nums.zipWithIndex
      .scanLeft(0) { case (dp, (j, i)) => dp.max(i + j) }
      .drop(1)
    def f(i: Int, step: Int): Int =
      if (i >= nums.length - 1) step else f(dp(i), step + 1)
    f(0, 0)
  }
}
// @lc code=end
