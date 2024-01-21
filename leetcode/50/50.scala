/*
 * @lc app=leetcode.cn id=50 lang=scala
 *
 * [50] Pow(x, n)
 */
package Q50

// @lc code=start
object Solution {
  def myPow(x: Double, n: Int): Double = {
    @annotation.tailrec
    def helper(x: Double, n: Long, res: Double = 1): Double = {
      if (n == 0) res
      else {
        helper(x * x, n / 2, if (n % 2 == 1) res * x else res)
      }
    }

    if (n >= 0) helper(x, n.toLong)
    else helper(1 / x, -(n.toLong))
  }
}
// @lc code=end
