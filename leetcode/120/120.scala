/*
 * @lc app=leetcode.cn id=120 lang=scala
 *
 * [120] 三角形最小路径和
 */
package Q120

// @lc code=start
object Solution {
  import scala.collection.mutable.HashMap
  def memorize[I, O](f: I => O): I => O = new HashMap[I, O]() {
    override def apply(key: I) = getOrElseUpdate(key, f(key))
  }
  def minimumTotal(triangle: List[List[Int]]): Int = {
    lazy val dfs: ((Int, Int)) => Int = memorize {
      case (i, j) if i == triangle.size => 0
      case (i, j) =>
        math.min(dfs(i + 1, j), dfs(i + 1, j + 1)) + triangle(i)(j)
    }
    dfs(0, 0)
  }
}
// @lc code=end
