/*
 * @lc app=leetcode.cn id=131 lang=scala
 *
 * [131] 分割回文串
 */
package Q131

// @lc code=start
object Solution {
  def partition(s: String): List[List[String]] = {
    val n = s.size
    val f = Array.fill(n, n)(false)
    s.indices.foreach(i => f(i)(i) = true)
    for {
      i <- s.indices
      j <- i - 1 to 0 by -1
      if s(i) == s(j)
    } {
      if (j + 1 == i) {
        f(j)(i) = true
      } else {
        f(j)(i) = f(j + 1)(i - 1)
      }
    }
    def dfs(i: Int, cur: List[String]): List[List[String]] = {
      if (i == n) {
        List(cur)
      } else {
        (i until n).foldLeft(List.empty[List[String]]) {
          case (acc, j) if f(i)(j) => acc ++ dfs(j + 1, cur :+ s.slice(i, j + 1))
          case (acc, _)            => acc
        }
      }
    }
    dfs(0, List.empty)
  }
}
// @lc code=end
