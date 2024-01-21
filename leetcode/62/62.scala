/*
 * @lc app=leetcode.cn id=62 lang=scala
 *
 * [62] 不同路径
 */
package Q62

// @lc code=start
object Solution {
  import scala.collection.mutable.HashMap
  def memorize[I, O](f: I => O): I => O = new HashMap[I, O]() {
    override def apply(key: I) = getOrElseUpdate(key, f(key))
  }
  def uniquePaths(m: Int, n: Int): Int = {
    lazy val dfs: ((Int, Int)) => Int = memorize {
      case (0, 0) => 1
      case (0, j) => dfs(0, j - 1)
      case (i, 0) => dfs(i - 1, 0)
      case (i, j) => dfs(i - 1, j) + dfs(i, j - 1)
    }
    dfs(m - 1, n - 1)
  }
}
// @lc code=end
