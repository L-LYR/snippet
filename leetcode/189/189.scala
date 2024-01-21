/*
 * @lc app=leetcode.cn id=189 lang=scala
 *
 * [189] 轮转数组
 */
package Q189

// @lc code=start
object Solution {
  def rotate(nums: Array[Int], k: Int): Unit = {
    @annotation.tailrec
    def reverse(from: Int, to: Int): Unit = {
      if (from < to) {
        val t = nums(from)
        nums.update(from, nums(to))
        nums.update(to, t)
        reverse(from + 1, to - 1)
      }
    }

    reverse(0, nums.size - 1)
    reverse(0, k % nums.size - 1)
    reverse(k % nums.size, nums.size - 1)
  }
}
// @lc code=end
