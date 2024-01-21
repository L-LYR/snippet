/*
 * @lc app=leetcode.cn id=153 lang=scala
 *
 * [153] 寻找旋转排序数组中的最小值
 */
package Q153

// @lc code=start
object Solution {
  def findMin(nums: Array[Int]): Int = {
    @annotation.tailrec
    def binarySearch(l: Int, r: Int): Int =
      if (l == r) {
        nums(l)
      } else {
        val m = (l + r) / 2
        if (nums(m) > nums(r))
          binarySearch(m + 1, r)
        else
          binarySearch(l, m)
      }

    binarySearch(0, nums.size - 1)
  }
}
// @lc code=end
