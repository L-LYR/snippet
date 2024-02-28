/*
 * @lc app=leetcode.cn id=746 lang=scala
 *
 * [746] 使用最小花费爬楼梯
 */
package Q746

// @lc code=start
object Solution {
  def minCostClimbingStairs(cost: Array[Int]): Int = {
    val (f0, f1) =
      cost.drop(2).foldLeft((cost(0), cost(1))) { case ((f0, f1), x) => (f1, (f0 min f1) + x) }
    f0 min f1
  }
}
// @lc code=end
