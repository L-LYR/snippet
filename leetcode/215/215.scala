/*
 * @lc app=leetcode.cn id=215 lang=scala
 *
 * [215] 数组中的第K个最大元素
 */
package Q215

// @lc code=start
object Solution {
  def findKthLargest(nums: Array[Int], kth: Int): Int = {
    @annotation.tailrec
    def helper(arr: Array[Int], k: Int): Int = {
      val pivot = arr.head
      val left = arr.filter(_ > pivot)
      val middle = arr.filter(_ == pivot)
      val right = arr.filter(_ < pivot)

      if (k <= left.size) {
        helper(left, k)
      } else if (k > left.size + middle.size) {
        helper(right, k - left.size - middle.size)
      } else {
        middle.head
      }
    }

    helper(nums, kth)
  }
}
// @lc code=end
