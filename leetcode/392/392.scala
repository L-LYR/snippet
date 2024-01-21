/*
 * @lc app=leetcode.cn id=392 lang=scala
 *
 * [392] 判断子序列
 */
package Q392

// @lc code=start
object Solution {
  def isSubsequence(s: String, t: String): Boolean = {
    s.size == 0 || t.foldLeft(0) {
      case (i, c) if i < s.size && c == s(i) => i + 1
      case (i, c)                            => i
    } == s.size
  }
}
// @lc code=end
