/*
 * @lc app=leetcode.cn id=14 lang=scala
 *
 * [14] 最长公共前缀
 */
package Q14

// @lc code=start
object Solution {
  def longestCommonPrefix(strs: Array[String]): String = {
    val minBy = strs.minBy(_.length).length
    strs
      .map(_.toList.take(minBy))
      .toList
      .transpose
      .takeWhile(lst => lst.forall(_ == lst.head))
      .map(_.head)
      .mkString
  }
}
// @lc code=end
