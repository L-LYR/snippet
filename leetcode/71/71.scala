/*
 * @lc app=leetcode.cn id=71 lang=scala
 *
 * [71] 简化路径
 */
package Q71

// @lc code=start
object Solution {
  import scala.collection.mutable.Stack
  def simplifyPath(path: String): String = {
    path
      .split("/+")
      .foldLeft(List[String]())((acc, cur) =>
        cur match {
          case ".."     => acc.drop(1)
          case "." | "" => acc
          case _        => cur +: acc
        }
      )
      .reverse
      .mkString("/", "/", "")
  }
}
// @lc code=end
