/*
 * @lc app=leetcode.cn id=1423 lang=scala
 *
 * [1423] 可获得的最大点数
 */
package Q1423

// @lc code=start
object Solution {
  def maxScore(cardPoints: Array[Int], k: Int): Int = {
    val ps = cardPoints.scanLeft(0) { case (acc, x) => acc + x }
    (0 to k).map(i => ps(i) + ps.last - ps(cardPoints.size - (k - i))).max
  }
}
// @lc code=end
