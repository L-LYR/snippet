/*
 * @lc app=leetcode.cn id=125 lang=scala
 *
 * [125] 验证回文串
 */
package Q125

// @lc code=start
object Solution {
  def isPalindrome(s: String): Boolean = {
    // val ss = s.filter(c => c.isDigit || c.isLetter).toLowerCase
    // ss.zip(ss.reverse).forall(p => p._1 == p._2)
    val ss = s.filter(_.isLetterOrDigit)
    ss.reverse.equalsIgnoreCase(ss)
  }
}
// @lc code=end
