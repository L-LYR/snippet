/*
 * @lc app=leetcode.cn id=2834 lang=scala
 *
 * [2834] 找出美丽数组的最小和
 */
package Q2834

// @lc code=start
object Solution {
  def minimumPossibleSum(n: Int, k: Int): Int = {
    val m = ((k / 2) min n).toLong
    ((m * (m + 1) + (n - m - 1 + k * 2) * (n - m)) / 2 % 1000000007).toInt
  }
}
// @lc code=end
