/*
 * @lc app=leetcode.cn id=11 lang=scala
 *
 * [11] 盛最多水的容器
 */
package Q11

// @lc code=start
object Solution {
  def maxArea(height: Array[Int]): Int = {
    @annotation.tailrec
    def helper(l: Int, r: Int, ans: Int): Int = {
      if (l == r) {
        ans
      } else {
        if (height(l) < height(r)) {
          helper(l + 1, r, (height(l) * (r - l)).max(ans))
        } else {
          helper(l, r - 1, (height(r) * (r - l)).max(ans))
        }
      }
    }
    helper(0, height.size - 1, 0)
  }
}
// @lc code=end
