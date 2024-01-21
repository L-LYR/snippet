/*
 * @lc app=leetcode.cn id=290 lang=scala
 *
 * [290] 单词规律
 */
package Q290

// @lc code=start
object Solution {
  def wordPattern(pattern: String, s: String): Boolean = {
    val ss = s.split(" ")
    val trans = pattern.zip(ss).toMap.map(_.swap)
    ss.length == pattern.length &&
    ss.map(trans.get(_)).zip(pattern).forall(p => p._1.contains(p._2))
  }
}
// @lc code=end
