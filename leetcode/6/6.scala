/*
 * @lc app=leetcode.cn id=6 lang=scala
 *
 * [6] Z 字形变换
 */
package Q6

// @lc code=start
object Solution {
  import scala.collection.immutable.SortedSet
  def convert(s: String, numRows: Int): String = {
    if (numRows == 1) s
    else
      (0 until numRows)
        .flatMap { r =>
          (r until s.length by ((numRows - 1) * 2)).flatMap { i =>
            SortedSet(i, i + (numRows - 1 - r) * 2 % ((numRows - 1) * 2))
          }
        }
        .filter(_ < s.length)
        .map(s)
        .mkString
  }
}
// @lc code=end
