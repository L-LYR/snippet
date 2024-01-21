/*
 * @lc app=leetcode.cn id=433 lang=scala
 *
 * [433] 最小基因变化
 */
package Q433

// @lc code=start
object Solution {
  def minMutation(startGene: String, endGene: String, bank: Array[String]): Int = {
    import scala.collection.immutable.Queue
    @annotation.tailrec
    def bfs(q: Queue[(String, Int)], may: Set[String]): Int = {
      q.dequeueOption match {
        case None                              => -1
        case Some(((g, k), _)) if g == endGene => k
        case Some(((g, k), nq)) => {
          val next = for {
            c <- "AGCT"
            i <- 0 until g.size
            val s = g.updated(i, c)
            if (may.contains(s))
          } yield s
          bfs(nq.enqueueAll(next.map((_, k + 1))), may -- next)
        }
      }
    }
    bfs(Queue((startGene,0)), bank.toSet)
  }
}
// @lc code=end
