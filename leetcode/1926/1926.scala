/*
 * @lc app=leetcode.cn id=1926 lang=scala
 *
 * [1926] 迷宫中离入口最近的出口
 */
package Q1926

// @lc code=start
object Solution {
  def nearestExit(maze: Array[Array[Char]], entrance: Array[Int]): Int = {
    val n = maze.size
    val m = maze(0).size
    val visited = Array.fill(n, m)(false)
    val e = (entrance(0), entrance(1))
    visited(entrance(0))(entrance(1)) = true
    val d = List((0, 1), (0, -1), (1, 0), (-1, 0))

    @annotation.tailrec
    def bfs(q: List[(Int, Int)], step: Int): Int = {
      if (q.isEmpty) {
        -1
      } else {
        if (
          q.filter { case (x, y) =>
            d.map { case (dx, dy) => (x + dx, y + dy) }
              .exists { case (x, y) => x < 0 || y < 0 || x >= n || y >= m }
          }.exists(_ != e)
        ) {
          step
        } else {
          val canStep = q
            .flatMap { case (x, y) => d.map { case (dx, dy) => (x + dx, y + dy) } }
            .filter { case (x, y) =>
              (x >= 0 && y >= 0 && x < n && y < m) && !visited(x)(y) && maze(x)(y) == '.'
            }
            .distinct
            .tapEach { case (x, y) => visited(x)(y) = true }
          bfs(canStep, step + 1)
        }
      }
    }

    bfs(List(e), 0)

  }
}
// @lc code=end
