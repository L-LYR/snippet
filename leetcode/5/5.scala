/*
 * @lc app=leetcode.cn id=5 lang=scala
 *
 * [5] 最长回文子串
 */
package Q5

// @lc code=start
object Solution {
  def longestPalindrome(s: String): String = {
    def longestPalindrome(left: Int, right: Int, result: String): String = {
      if (left + result.length >= s.length) {
        result
      } else if (result.length >= right - left + 1 || isPalindrome(left, right)) {
        longestPalindrome(
          left + 1,
          s.length - 1,
          if (result.length >= right - left + 1) result else s.substring(left, right + 1)
        )
      } else {
        longestPalindrome(left, right - 1, result)
      }
    }

    def isPalindrome(left: Int, right: Int): Boolean = {
      if (left >= right) true
      else if (s(left) != s(right)) false
      else isPalindrome(left + 1, right - 1)
    }

    if (s.isEmpty) ""
    else longestPalindrome(0, s.length - 1, s.substring(0, 1))
  }
}
// @lc code=end
