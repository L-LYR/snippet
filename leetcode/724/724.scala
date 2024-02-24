/*
 * @lc app=leetcode.cn id=724 lang=scala
 *
 * [724] 寻找数组的中心下标
 */
package Q724

// @lc code=start
object Solution {
  def pivotIndex(nums: Array[Int]): Int = {
    val s = nums.sum
    nums.iterator
      .scanLeft(0) { case (acc, x) => acc + x }
      .take(nums.size)
      .zip(nums)
      .zipWithIndex
      .find { case ((l, x), i) => s - l - x == l }
      .map(_._2)
      .getOrElse(-1)
  }
}
// @lc code=end
