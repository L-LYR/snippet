/*
 * @lc app=leetcode.cn id=1466 lang=scala
 *
 * [1466] 重新规划路线
 */
package Q1466

// @lc code=start
object Solution {
  def minReorder(n: Int, connections: Array[Array[Int]]): Int = {
    import scala.collection.immutable.Queue
    val g = connections.zipWithIndex
      .flatMap { case (Array(u, v), i) => List((u, i), (v, i)) }
      .groupMapReduce(_._1)(p => List(p._2))(_ ++ _)
    @annotation.tailrec
    def bfs(q: Queue[Int], visited: Set[Int], ans: Int): Int = {
      q.dequeueOption match {
        case None => ans
        case Some((x, nq)) => {
          val nextEdges = g.getOrElse(x, List.empty).map(connections(_))
          val reverseEdges = nextEdges.collect {
            case Array(u, v) if u == x && !visited.contains(v) => v
          }
          val stepEdges = nextEdges.collect {
            case Array(u, v) if v == x && !visited.contains(u) => u
          }
          bfs(
            nq.enqueueAll(reverseEdges).enqueueAll(stepEdges),
            visited ++ reverseEdges ++ stepEdges,
            ans + reverseEdges.size
          )
        }
      }
    }
    bfs(Queue(0), Set(0), 0)
  }
}
// @lc code=end
