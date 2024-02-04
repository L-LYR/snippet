/*
 * @lc app=leetcode.cn id=514 lang=scala
 *
 * [514] 自由之路
 */
package Q514

// @lc code=start
object Solution {
  import scala.collection.immutable.Queue
  def findRotateSteps(ring: String, key: String): Int = {
    val n = ring.size
    val m = key.size
    @annotation.tailrec
    def bfs(q: Queue[(Int, Int, Int)], visited: Set[(Int, Int)]): Int = {
      q.dequeueOption match {
        case None                            => -1
        case Some(((i, j, d), nq)) if i == m => d
        case Some(((i, j, d), nq)) if ring(j) == key(i) =>
          if (!visited.contains((i + 1, j))) bfs(nq :+ (i + 1, j, d + 1), visited + ((i + 1, j)))
          else bfs(nq, visited)
        case Some(((i, j, d), nq)) => {
          val ns = Seq((j + 1) % n, (j - 1 + n) % n).map((i, _)).filter(!visited.contains(_))
          bfs(nq.enqueueAll(ns.map(p => (p._1, p._2, d + 1))), visited ++ ns)
        }
      }
    }
    bfs(Queue((0, 0, 0)), Set((0, 0)))
  }
}
// @lc code=end
