/*
 * @lc app=leetcode.cn id=238 lang=scala
 *
 * [238] 除自身以外数组的乘积
 */
package Q238

// @lc code=start
object Solution {
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    if (nums.length <= 1) {
      nums
    } else {
      val R = nums.dropRight(1).scanLeft(1)((acc, n) => acc * n)
      val L = nums.drop(1).scanRight(1)((acc, n) => acc * n)
      R.zip(L).map { case (x, y) => x * y }
    }
  }
}
// @lc code=end
