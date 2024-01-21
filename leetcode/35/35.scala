/*
 * @lc app=leetcode.cn id=35 lang=scala
 *
 * [35] 搜索插入位置
 */
package Q35

// @lc code=start
object Solution {
  def searchInsert(nums: Array[Int], target: Int): Int = {
    @annotation.tailrec
    def binarySearch(l: Int, r: Int): Int = {
      if (l == r) {
        l
      } else {
        val m = (r - l) / 2 + l
        if (nums(m) == target) {
          m
        } else if (nums(m) < target) {
          binarySearch(m + 1, r)
        } else {
          binarySearch(l, m)
        }
      }
    }

    binarySearch(0, nums.length)
  }
}
// @lc code=end
