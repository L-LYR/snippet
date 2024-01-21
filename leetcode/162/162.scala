/*
 * @lc app=leetcode.cn id=162 lang=scala
 *
 * [162] 寻找峰值
 */
package Q162

// @lc code=start
object Solution {
  def findPeakElement(nums: Array[Int]): Int = {
    @annotation.tailrec
    def binarySearch(l: Int, r: Int): Int = {
      if (l == r) {
        l
      } else {
        val m = (r - l) / 2 + l
        if (nums(m) > nums(m + 1)) {
          binarySearch(l, m)
        } else {
          binarySearch(m + 1, r)
        }
      }
    }

    binarySearch(0, nums.length - 1)
  }
}
// @lc code=end
