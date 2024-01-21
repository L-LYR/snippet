/*
 * @lc app=leetcode.cn id=452 lang=scala
 *
 * [452] 用最少数量的箭引爆气球
 */
package Q452

// @lc code=start
object Solution {
  def findMinArrowShots(points: Array[Array[Int]]): Int = {
    val all =
      points.sortWith((l, r) => l(0) < r(0) || (l(0) == r(0) && l(1) < r(1)))
    all
      .drop(1)
      .foldLeft((all(0)(0), all(0)(1), 1)) {
        case ((l, r, n), Array(ll, rr)) if r >= ll => {
          (l max ll, r min rr, n)
        }
        case ((l, r, n), Array(ll, rr)) => {
          (ll, rr, n + 1)
        }
      }
      ._3
  }
}
// @lc code=end
