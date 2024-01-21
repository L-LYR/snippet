/*
 * @lc app=leetcode.cn id=63 lang=scala
 *
 * [63] 不同路径 II
 */
package Q63

// @lc code=start
object Solution {
  import scala.collection.mutable.HashMap
  def memorize[I, O](f: I => O): I => O = new HashMap[I, O]() {
    override def apply(key: I) = getOrElseUpdate(key, f(key))
  }
  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
    lazy val dfs: ((Int, Int)) => Int = memorize {
      case (i, j) if obstacleGrid(i)(j) == 1 => 0
      case (0, 0)                            => 1
      case (0, j)                            => dfs(0, j - 1)
      case (i, 0)                            => dfs(i - 1, 0)
      case (i, j)                            => dfs(i - 1, j) + dfs(i, j - 1)
    }
    dfs(obstacleGrid.size - 1, obstacleGrid(0).size - 1)
  }
}
// @lc code=end
