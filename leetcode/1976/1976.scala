/*
 * @lc app=leetcode.cn id=1976 lang=scala
 *
 * [1976] 到达目的地的方案数
 */
package Q1976

// @lc code=start
object Solution {
  def countPaths(n: Int, roads: Array[Array[Int]]): Int = {
    import scala.collection.mutable.PriorityQueue
    val g = roads
      .flatMap(r => Seq((r(0), (r(1), r(2))), (r(1), (r(0), r(2)))))
      .groupMapReduce(_._1)(p => List(p._2))(_ ++ _)
    val distance = Array.fill(n)(Long.MaxValue)
    val f = Array.fill(n)(0)
    val q = new PriorityQueue()(
      Ordering.by[(Long, Int), Long](p => p._1).reverse
    )

    f.update(0, 1)
    distance.update(0, 0)
    q.enqueue((0.toLong, 0))

    @annotation.tailrec
    def loop(): Int = {
      q.dequeue() match {
        case (dx, x) if x == n - 1       => f(n - 1)
        case (dx, x) if dx > distance(x) => loop()
        case (dx, x) => {
          g.getOrElse(x, List.empty).foreach {
            case (y, d) => {
              val nd = dx + d
              if (nd < distance(y)) {
                distance.update(y, nd)
                f.update(y, f(x))
                q.enqueue((nd, y))
              } else if (nd == distance(y)) {
                f.update(y, (f(y) + f(x)) % 1000000007)
              }
            }
          }
          loop()
        }
      }
    }

    loop()
  }
}
// @lc code=end
