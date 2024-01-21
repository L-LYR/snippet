/*
 * @lc app=leetcode.cn id=149 lang=scala
 *
 * [149] 直线上最多的点数
 */
package Q149

// @lc code=start
object Solution {
  def maxPoints(points: Array[Array[Int]]): Int = {
    @annotation.tailrec
    def gcd(a: Int, b: Int): Int = {
      if (b == 0) a else gcd(b, a % b)
    }
    def k(x1: Int, x2: Int, y1: Int, y2: Int): Int = {
      val (a, b) = {
        (x2 - x1) match {
          case 0             => (0, 1)
          case _ if y2 == y1 => (1, 0)
          case dx if dx < 0  => (-dx, y1 - y2)
          case dx            => (dx, y2 - y1)
        }
      }
      val m = gcd(a, b)
      20001 * (b / m) + a / m
    }

    points.toSeq
      .combinations(2)
      .map {
        case Seq(Array(x1, y1), Array(x2, y2)) => {
          (x1, y1) -> k(x1, x2, y1, y2)
        }
      }
      .toArray
      .groupMap(_._1)(_._2)
      .values
      .map(_.groupBy(identity).values.map(_.length).max + 1)
      .maxOption
      .getOrElse(1)
  }
}
// @lc code=end
