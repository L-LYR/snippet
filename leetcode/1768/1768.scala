/*
 * @lc app=leetcode.cn id=1768 lang=scala
 *
 * [1768] 交替合并字符串
 */
package Q1768

// @lc code=start
object Solution {
  def mergeAlternately(word1: String, word2: String): String = {
    word1.iterator
      .map(_.toString)
      .zipAll(word2.iterator.map(_.toString), "", "")
      .flatMap { case (l, r) => l + r }
      .mkString
  }
}
// @lc code=end
