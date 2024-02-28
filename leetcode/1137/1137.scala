/*
 * @lc app=leetcode.cn id=1137 lang=scala
 *
 * [1137] 第 N 个泰波那契数
 */
package Q1137

// @lc code=start
object Solution {
  @scala.annotation.tailrec
  def tribonacci(n: Int, T0: Int = 0, T1: Int = 1, T2: Int = 1): Int =
    if (n > 0) tribonacci(n - 1, T1, T2, T0 + T1 + T2)
    else T0
}
// @lc code=end
