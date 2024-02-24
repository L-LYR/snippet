/*
 * @lc app=leetcode.cn id=1004 lang=scala
 *
 * [1004] 最大连续1的个数 III
 */
package Q1004

// @lc code=start
object Solution {
  def longestOnes(nums: Array[Int], k: Int): Int = {
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
    helper(0, 0, 0, 0)
  }
}
// @lc code=end
