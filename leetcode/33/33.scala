/*
 * @lc app=leetcode.cn id=33 lang=scala
 *
 * [33] 搜索旋转排序数组
 */
package Q33

// @lc code=start
object Solution {
  def search(nums: Array[Int], target: Int): Int = {

    @annotation.tailrec
    def binarySearch(l: Int, r: Int): Int = {
      if (l == r) {
        -1
      } else {
        val m = (r - l) / 2 + l
        if (nums(m) == target) {
          m
        } else if (nums(0) > target) {
          if (nums(m) < nums(0) && nums(m) > target) {
            binarySearch(l, m)
          } else {
            binarySearch(m + 1, r)
          }
        } else {
          if (nums(m) > nums(0) && nums(m) < target) {
            binarySearch(m + 1, r)
          } else {
            binarySearch(l, m)
          }
        }
      }
    }

    if (nums(0) == target) { 0 }
    else { binarySearch(1, nums.length) }
  }
}
// @lc code=end
