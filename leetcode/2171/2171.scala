/*
 * @lc app=leetcode.cn id=2171 lang=scala
 *
 * [2171] 拿出最少数目的魔法豆
 */
package Q2171

// @lc code=start
object Solution {
  def minimumRemoval(beans: Array[Int]): Long = {
    val s = beans.map(_.toLong).sum
    beans.sorted.zipWithIndex.foldLeft(s) { case (mx, (x, i)) =>
      mx.min(s - x.toLong * (beans.size - i))
    }
  }
}
// @lc code=end
