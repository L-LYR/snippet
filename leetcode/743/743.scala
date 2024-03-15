/*
 * @lc app=leetcode.cn id=743 lang=scala
 *
 * [743] 网络延迟时间
 */
package Q743

// @lc code=start
object Solution {
  def networkDelayTime(times: Array[Array[Int]], n: Int, k: Int): Int = {
    val g = times.groupMapReduce(p => p(0))(p => List((p(1), p(2))))(_ ++ _)
    val distance = Array.fill(n + 1)(Int.MaxValue)
    import scala.collection.mutable.PriorityQueue
    val q = new PriorityQueue()(Ordering.by[(Int, Int), Int](p => p._1).reverse)

    distance.update(k, 0)
    q.enqueue((0, k))

    @annotation.tailrec
    def loop(): Int = {
      if (q.isEmpty) {
        val ans = distance.drop(1).max
        if (ans == Int.MaxValue) -1 else ans
      } else {
        q.dequeue() match {
          case (dx, x) => {
            q.addAll(
              g.getOrElse(x, List.empty)
                .map(p => (p._2 + dx, p._1))
                .filter(p => p._1 < distance(p._2))
                .tapEach { case (d, y) => distance.update(y, d) }
            )
          }
        }
        loop()
      }
    }

    loop()
  }
}
// @lc code=end
