/*
 * @lc app=leetcode.cn id=29 lang=scala
 *
 * [29] 两数相除
 */
package Q29

// @lc code=start
object Solution {
  val lim = Int.MinValue / 2
  def divide(a: Int, b: Int): Int = {
    if (a == Int.MinValue && b == -1) {
      Int.MaxValue
    } else {
      val positive = (a >= 0) == (b >= 0)

      @annotation.tailrec
      def probe(a: Int, b: Int, c: Int, d: Int): (Int, Int) = {
        if (c >= lim && d >= lim && a - c <= c) {
          probe(a, b, c + b, d - 1)
        } else {
          (c, d)
        }
      }

      @annotation.tailrec
      def loop(a: Int, b: Int, r: Int = 0): Int = {
        if (a <= b) {
          // val (c, d) = probe(a, b, b, -1)
          // loop(a - c, b, r + d)
          loop(a - b, b, r - 1)
        } else {
          r
        }
      }

      val x = loop(-a.abs, -b.abs)

      if (positive) -x else x
    }
  }
}
// @lc code=end
