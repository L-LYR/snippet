/*
 * @lc app=leetcode.cn id=871 lang=scala
 *
 * [871] 最低加油次数
 */
package Q871

// @lc code=start
object Solution {
  import scala.collection.mutable.PriorityQueue
  def minRefuelStops(target: Int, startFuel: Int, stations: Array[Array[Int]]): Int = {
    stations.sortInPlaceBy(_(0))
    val s = stations :+ (Array(target, 0))
    val q = PriorityQueue.empty[Int]
    @annotation.tailrec
    def loop(i: Int, f: Int, d: Int, c: Int): Int = {
      if (i == s.size) {
        c
      } else {
        val need = s(i)(0) - d
        if (!q.isEmpty && f < need) {
          loop(i, f + q.dequeue(), d, c + 1)
        } else if (f >= need) {
          q.enqueue(s(i)(1))
          loop(i + 1, f - need, s(i)(0), c)
        } else {
          -1
        }
      }
    }
    loop(0, startFuel, 0, 0)
  }
}
// @lc code=end
