/*
 * @lc app=leetcode.cn id=154 lang=scala
 *
 * [154] 寻找旋转排序数组中的最小值 II
 */
package Q154

// @lc code=start
object Solution {
  def findMin(nums: Array[Int]): Int = {
    @annotation.tailrec
    def binarySearch(l: Int, r: Int): Int =
      if (l == r) {
        nums(l)
      } else {
        val m = (l + r) / 2
        if (nums(m) > nums(r)) {
          binarySearch(m + 1, r)
        } else if (nums(m) < nums(r)) {
          binarySearch(l, m)
        } else {
          binarySearch(l, r - 1)
        }
      }

    binarySearch(0, nums.size - 1)
  }
}
// @lc code=end
