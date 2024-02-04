/*
 * @lc app=leetcode.cn id=1690 lang=scala
 *
 * [1690] 石子游戏 VII
 */
package Q1690

// @lc code=start
object Solution {
  def stoneGameVII(stones: Array[Int]): Int = {
    val n = stones.size
    val prefixSum = stones.scanLeft(0) { case (acc, x) => acc + x }
    val f = Array.fill(n, n)(0)
    for {
      i <- (n - 2) to 0 by -1
      j <- (i + 1) until n
    } {
      f(i)(j) = prefixSum(j + 1) - prefixSum(i + 1) - f(i + 1)(j) max
        prefixSum(j) - prefixSum(i) - f(i)(j - 1)
    }
    f(0)(n - 1)
  }
}
// @lc code=end
