/*
 * @lc app=leetcode.cn id=399 lang=scala
 *
 * [399] 除法求值
 */
package Q399

// @lc code=start
object Solution {
  def calcEquation(
      equations: List[List[String]],
      values: Array[Double],
      queries: List[List[String]]
  ): Array[Double] = {
    import scala.collection.immutable.Queue
    val g = equations
      .zip(values)
      .collect { case (List(s, t), v) =>
        List((s, (t, v)), (t, (s, 1.0 / v)), (t, (t, 1.0)), (s, (s, 1.0)))
      }
      .flatten
      .distinct
      .groupMapReduce(_._1)(p => Map(p._2))(_ ++ _)
    @annotation.tailrec
    def bfs(q: Queue[(String, Double)], t: String, visited: Set[String]): Double = {
      q.dequeueOption match {
        case None => -1.0
        case Some(((c, x), nq)) =>
          g.getOrElse(c, None).find(_._1 == t) match {
            case None => {
              val next =
                g.getOrElse(c, None)
                  .filter(p => !visited.contains(p._1))
                  .map({ case (n, y) => (n, y * x) })
                  .toSeq
              bfs(nq.enqueueAll(next), t, visited ++ next.map(_._1))
            }
            case Some((_, y)) => x * y
          }
      }
    }
    queries.map(p => bfs(Queue(p(0) -> 1.0), p(1), Set(p(0)))).toArray
  }
}
// @lc code=end
