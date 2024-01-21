/*
 * @lc app=leetcode.cn id=58 lang=scala
 *
 * [58] 最后一个单词的长度
 */
package Q58

// @lc code=start
object Solution {
  def lengthOfLastWord(s: String): Int = {
    s.reverse.trim().takeWhile(_ != ' ').length
  }
}
// @lc code=end
