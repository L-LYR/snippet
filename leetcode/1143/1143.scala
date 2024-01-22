/*
 * @lc app=leetcode.cn id=1143 lang=scala
 *
 * [1143] 最长公共子序列
 */
package Q1143

// @lc code=start
object Solution {
  def longestCommonSubsequence(text1: String, text2: String): Int = {
    val f = Array.fill(text1.size + 1, text2.size + 1)(0)
    for {
      i <- text1.indices
      j <- text2.indices
    } {
      if (text1(i) == text2(j)) {
        f(i + 1)(j + 1) = f(i)(j) + 1
      } else {
        f(i + 1)(j + 1) = f(i + 1)(j) max f(i)(j + 1)
      }
    }
    f(text1.size)(text2.size)
  }
}
// @lc code=end
