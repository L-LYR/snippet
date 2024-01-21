/*
 * @lc app=leetcode.cn id=200 lang=scala
 *
 * [200] 岛屿数量
 */
package Q200

// @lc code=start
object Solution {
  def numIslands(grid: Array[Array[Char]]): Int = {
    def dfs(i: Int, j: Int): Int = {
      if (i < 0 || j < 0 || i >= grid.size || j >= grid(0).size || grid(i)(j) != '1') {
        0
      } else {
        grid(i)(j) = '.'
        dfs(i - 1, j) + dfs(i + 1, j) + dfs(i, j - 1) + dfs(i, j + 1)
        1
      }
    }
    (for {
      i <- 0 to grid.size
      j <- 0 to grid(0).size
    } yield dfs(i, j)).sum
  }
}
// @lc code=end
