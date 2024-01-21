/*
 * @lc app=leetcode.cn id=9 lang=scala
 *
 * [9] 回文数
 */
package Q9

// @lc code=start
object Solution {
  def isPalindrome(x: Int): Boolean = {
    @annotation.tailrec
    def helper(x: Int, r: Int = 0): Int = {
      if (x == 0) { r }
      else { helper(x / 10, r * 10 + x % 10) }
    }
    x >= 0 && helper(x) == x
  }
}
// @lc code=end
