/*
 * @lc app=leetcode.cn id=2352 lang=scala
 *
 * [2352] 相等行列对
 */
package Q2352

// @lc code=start
object Solution {
  def equalPairs(grid: Array[Array[Int]]): Int = {
    val row = grid.map(_.toSeq.mkString("#")).groupBy(identity).mapValues(_.size)
    grid.transpose.map(col => row.getOrElse(col.toSeq.mkString("#"), 0)).sum
  }
}
// @lc code=end
