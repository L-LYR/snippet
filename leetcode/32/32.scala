/*
 * @lc app=leetcode.cn id=32 lang=scala
 *
 * [32] 最长有效括号
 */
package Q32

// @lc code=start
object Solution {
  def longestValidParentheses(s: String): Int = {
    if (s.size == 0) { 0 }
    else {
      val f = Array.fill(s.size)(0)
      for {
        i <- 1 until s.size
        if s(i) == ')'
      } {
        if (s(i - 1) == '(') {
          f(i) = 2 + (if (i >= 2) f(i - 2) else 0)
        } else {
          val j = i - f(i - 1) - 1
          if (j >= 0 && s(j) == '(') {
            f(i) = f(i - 1) + 2 + (if (j >= 1) f(j - 1) else 0)
          }
        }
      }
      f.max
    }
  }
}
// @lc code=end
