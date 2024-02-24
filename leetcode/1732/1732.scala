/*
 * @lc app=leetcode.cn id=1732 lang=scala
 *
 * [1732] 找到最高海拔
 */
package Q1732

// @lc code=start
object Solution {
  def largestAltitude(gain: Array[Int]): Int = {
    gain.scanLeft(0) { case (acc, x) => acc + x }.max
  }
}
// @lc code=end
