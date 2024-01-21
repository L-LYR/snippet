/*
 * @lc app=leetcode.cn id=55 lang=scala
 *
 * [55] 跳跃游戏
 */
package Q55

// @lc code=start
object Solution {
  def canJump(nums: Array[Int]): Boolean = {
    val n = nums.length
    0 == (n - 1 to 0 by -1).foldLeft(n - 1)((l, p) => if (nums(p) + p >= l) p else l)
  }
}
// @lc code=end
