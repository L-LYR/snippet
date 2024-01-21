/*
 * @lc app=leetcode.cn id=64 lang=scala
 *
 * [64] 最小路径和
 */
package Q64

// @lc code=start
object Solution {
  import scala.collection.mutable.HashMap
  def memorize[I, O](f: I => O): I => O = new HashMap[I, O]() {
    override def apply(key: I) = getOrElseUpdate(key, f(key))
  }
  def minPathSum(grid: Array[Array[Int]]): Int = {
    lazy val dfs: ((Int, Int)) => Int = memorize {
      case (0, 0) => grid(0)(0)
      case (0, j) => dfs(0, j - 1) + grid(0)(j)
      case (i, 0) => dfs(i - 1, 0) + grid(i)(0)
      case (i, j) => math.min(dfs(i - 1, j), dfs(i, j - 1)) + grid(i)(j)
    }

    dfs(grid.size - 1, grid(0).size - 1)
  }
}
// @lc code=end
