/*
 * @lc app=leetcode.cn id=151 lang=scala
 *
 * [151] 反转字符串中的单词
 */
package Q151

// @lc code=start
object Solution {
  def reverseWords(s: String): String = {
    s.trim().split(' ').filter(_.length > 0).reverse.mkString(" ")
  }
}
// @lc code=end
