/*
 * @lc app=leetcode.cn id=274 lang=scala
 *
 * [274] H 指数
 */
package Q274

// @lc code=start
object Solution {
  def hIndex(citations: Array[Int]): Int = {
    citations.sorted.foldRight(0) { case (x, h) =>
      if (x < h) return h
      else x.min(h + 1)
    }
  }
}
// @lc code=end
