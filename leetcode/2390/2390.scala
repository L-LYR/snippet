/*
 * @lc app=leetcode.cn id=2390 lang=scala
 *
 * [2390] 从字符串中移除星号
 */
package Q2390

// @lc code=start
object Solution {
  def removeStars(s: String): String = {
    s.foldLeft("") {
      case (cs, '*') if cs.lastOption.map(_ != '*').getOrElse(false) =>
        cs.init
      case (cs, c) => cs :+ c
    }
  }
}
// @lc code=end
