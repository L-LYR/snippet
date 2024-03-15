/*
 * @lc app=leetcode.cn id=303 lang=scala
 *
 * [303] 区域和检索 - 数组不可变
 */
package Q303

// @lc code=start
class NumArray(_nums: Array[Int]) {
  val prefixSum = _nums.scanLeft(0) { case (acc, x) => acc + x }

  def sumRange(left: Int, right: Int): Int = {
    prefixSum(right + 1) - prefixSum(left)
  }
}
// @lc code=end
