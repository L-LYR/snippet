/*
 * @lc app=leetcode.cn id=136 lang=scala
 *
 * [136] 只出现一次的数字
 */
package Q136

// @lc code=start
object Solution {
  def singleNumber(nums: Array[Int]): Int = {
    nums.fold(0)((x: Int, y: Int) => x ^ y)
  }
}
// @lc code=end
