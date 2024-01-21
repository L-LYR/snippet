/*
 * @lc app=leetcode.cn id=205 lang=scala
 *
 * [205] 同构字符串
 */
package Q205

// @lc code=start
object Solution {
  def isIsomorphic(s: String, t: String): Boolean = {
    val trans = s.zip(t).toMap.map(_.swap)
    t.map(trans.get(_)).zip(s).forall(p => p._1.contains(p._2))
  }
}
// @lc code=end
