/*
 * @lc app=leetcode.cn id=1293 lang=scala
 *
 * [1293] 网格中的最短路径
 */
package Q1293

// @lc code=start
object Solution {
  import scala.collection.immutable.Queue
  def shortestPath(grid: Array[Array[Int]], k: Int): Int = {
    val ds = Array((0, 1), (1, 0), (-1, 0), (0, -1))
    val m = grid.size
    val n = grid(0).size
    def bfs(q: Queue[(Int, Int, Int, Int)], visited: Set[(Int, Int, Int)]): Int = {
      q.dequeueOption match {
        case None                                                 => -1
        case Some(((x, y, _, cd), _)) if x == m - 1 && y == n - 1 => cd
        case Some(((x, y, ck, cd), rq)) => {
          val nloc = ds
            .map { case (dx, dy) => (x + dx, y + dy) }
            .filter { case (i, j) => i >= 0 && i < m && j >= 0 && j < n }
            .filterNot { case (i, j) =>
              if (grid(i)(j) == 1) { (ck == k || visited.contains((i, j, ck + 1))) }
              else { visited.contains((i, j, ck)) }
            }
          val nq = rq.enqueueAll(
            nloc.map { case (i, j) =>
              if (grid(i)(j) == 1) { (i, j, ck + 1, cd + 1) }
              else { (i, j, ck, cd + 1) }
            }
          )
          val nvisited = visited ++ nloc.map { case (i, j) =>
            if (grid(i)(j) == 1) { (i, j, ck + 1) }
            else { (i, j, ck) }
          }
          bfs(nq, nvisited)
        }
      }
    }
    bfs(Queue((0, 0, 0, 0)), Set((0, 0, 0)))
  }
}
// @lc code=end
