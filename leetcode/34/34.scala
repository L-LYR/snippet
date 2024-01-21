/*
 * @lc app=leetcode.cn id=34 lang=scala
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */
package Q34

// @lc code=start
object Solution {
  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    @annotation.tailrec
    def binarySearch(fn: Int => Boolean)(l: Int, r: Int): Int = {
      if (l == r) {
        l
      } else {
        val m = (r - l) / 2 + l;
        if (fn(nums(m))) {
          binarySearch(fn)(l, m)
        } else {
          binarySearch(fn)(m + 1, r)
        }
      }
    }

    def lowerBound(l: Int, r: Int): Int = binarySearch(_ >= target)(l, r)
    def upperBound(l: Int, r: Int): Int = binarySearch(_ > target)(l, r)

    val lb = lowerBound(0, nums.length)
    val ub = upperBound(0, nums.length)
    if (lb == nums.length || nums(lb) != target) {
      Array(-1, -1)
    } else {
      Array(lb, ub - 1)
    }

  }
}
// @lc code=end
