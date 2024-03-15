/*
 * @lc app=leetcode.cn id=2226 lang=scala
 *
 * [2226] 每个小孩最多能分到多少糖果
 */
package Q2226

// @lc code=start
object Solution {
  def maximumCandies(candies: Array[Int], k: Long): Int = {
    @annotation.tailrec
    def binarySearch(l: Int, r: Int): Int = {
      if (l == r) {
        r
      } else {
        val m = (r - l + 1) / 2 + l
        val p = candies.foldLeft(0.toLong) {
          case (acc, x) if m > 0 => acc + x / m
          case (acc, x)          => acc
        }
        if (p < k) {
          binarySearch(l, m - 1)
        } else {
          binarySearch(m, r)
        }
      }
    }
    binarySearch(0, candies.max + 1)
  }
}
// @lc code=end
