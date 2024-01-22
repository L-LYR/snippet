/*
 * @lc app=leetcode.cn id=279 lang=scala
 *
 * [279] 完全平方数
 */
package Q279

// @lc code=start
object Solution {
  def numSquares(n: Int): Int = {
    val m = Stream.from(1).takeWhile(i => i * i <= n).last
    val f = Array.fill(m + 1, n + 1)(Int.MaxValue)
    f(0)(0) = 0
    for {
      i <- 1 to m
      val x = i * i
      j <- 0 to n
    } {
      if (j < x) {
        f(i)(j) = f(i - 1)(j)
      } else {
        f(i)(j) = f(i - 1)(j) min (f(i)(j - x) + 1)
      }
    }
    f(m)(n)
  }
}
// @lc code=end
