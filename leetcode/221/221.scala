/*
 * @lc app=leetcode.cn id=221 lang=scala
 *
 * [221] 最大正方形
 */
package Q221

// @lc code=start
object Solution {
  def maximalSquare(matrix: Array[Array[Char]]): Int = {
    val m = matrix.size
    val n = matrix(0).size
    val dp = Array.ofDim[Int](m, n)
    for {
      i <- 0 until m
      j <- 0 until n
      if (matrix(i)(j) == '1')
    } {
      if (i == 0 || j == 0) {
        dp(i)(j) = 1
      } else {
        dp(i)(j) = (dp(i - 1)(j - 1) min dp(i - 1)(j) min dp(i)(j - 1)) + 1
      }
    }
    val x = dp.flatten.max
    x * x
  }
}
// @lc code=end
