/*
 * @lc app=leetcode.cn id=2788 lang=scala
 *
 * [2788] 按分隔符拆分字符串
 */
package Q2788

// @lc code=start
object Solution {
  def splitWordsBySeparator(words: List[String], separator: Char): List[String] = {
    words.flatMap(_.split(separator).filter(_.size > 0)).toList
  }
}
// @lc code=end
