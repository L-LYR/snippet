/*
 * @lc app=leetcode.cn id=980 lang=scala
 *
 * [980] 不同路径 III
 */
package Q980

// @lc code=start
object Solution {
  def uniquePathsIII(grid: Array[Array[Int]]): Int = {
    val m = grid.size
    val n = grid(0).size
    val (si, sj) = (for {
      i <- grid.indices
      j <- grid(i).indices
      if grid(i)(j) == 1
    } yield (i, j)).head
    val all = grid.map(_.count(_ == 0)).sum + 1
    def dfs(i: Int, j: Int, k: Int): Int = {
      if (i < 0 || j < 0 || i >= m || j >= n || grid(i)(j) == -1) {
        0
      } else if (grid(i)(j) == 2) {
        if (k == 0) 1 else 0
      } else {
        grid(i)(j) = -1
        val res = dfs(i + 1, j, k - 1) + dfs(i - 1, j, k - 1) +
          dfs(i, j - 1, k - 1) + dfs(i, j + 1, k - 1)
        grid(i)(j) = 0
        res
      }
    }
    dfs(si, sj, all)
  }
}
// @lc code=end
