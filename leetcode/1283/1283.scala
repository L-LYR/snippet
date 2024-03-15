/*
 * @lc app=leetcode.cn id=1283 lang=scala
 *
 * [1283] 使结果不超过阈值的最小除数
 */
package Q1283

// @lc code=start
object Solution {
  def smallestDivisor(nums: Array[Int], threshold: Int): Int = {
    @annotation.tailrec
    def binarySearch(l: Int, r: Int): Int = {
      if (l == r) {
        l
      } else {
        val m = (r - l) / 2 + l
        val s = nums.foldLeft(0) { case (acc, x) =>
          acc + (x + m - 1) / m
        }
        if (s <= threshold) {
          binarySearch(l, m)
        } else {
          binarySearch(m + 1, r)
        }
      }
    }
    binarySearch(1, 1e6.toInt)
  }
}
// @lc code=end
