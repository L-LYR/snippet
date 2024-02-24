/*
 * @lc app=leetcode.cn id=1493 lang=scala
 *
 * [1493] 删掉一个元素以后全为 1 的最长子数组
 */
package Q1493

// @lc code=start
object Solution {
  def longestSubarray(nums: Array[Int]): Int = {
    val k = 1
    @annotation.tailrec
    def helper(zeros: Int, l: Int, r: Int, ans: Int): Int = {
      if (r == nums.size) {
        ans
      } else if (nums(r) == 1) {
        helper(zeros, l, r + 1, ans.max(r - l + 1))
      } else if (zeros < k) {
        helper(zeros + 1, l, r + 1, ans.max(r - l + 1))
      } else if (l < r) {
        if (nums(l) == 1) {
          helper(zeros, l + 1, r, ans)
        } else {
          helper(zeros - 1, l + 1, r, ans)
        }
      } else {
        helper(zeros, l + 1, l + 1, ans)
      }
    }
    helper(0, 0, 0, 0) - 1
  }
}
// @lc code=end
