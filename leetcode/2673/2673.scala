/*
 * @lc app=leetcode.cn id=2673 lang=scala
 *
 * [2673] 使二叉树所有路径值相等的最小代价
 */
package Q2673

// @lc code=start
object Solution {
  def minIncrements(n: Int, cost: Array[Int]): Int = {
    def dfs(x: Int): (Int, Int) = {
      if (x >= n) { (0, 0) }
      else {
        val (leftDiff, leftPath) = dfs(2 * x + 1)
        val (rightDiff, rightPath) = dfs(2 * x + 2)
        val diff = math.abs(leftPath - rightPath)
        (leftDiff + rightDiff + diff, diff + math.min(leftPath, rightPath) + cost(x))
      }
    }
    dfs(0)._1
  }
}
// @lc code=end
