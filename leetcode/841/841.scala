/*
 * @lc app=leetcode.cn id=841 lang=scala
 *
 * [841] 钥匙和房间
 */
package Q841

// @lc code=start
object Solution {
  def canVisitAllRooms(rooms: List[List[Int]]): Boolean = {
    import scala.collection.immutable.Queue
    def search(q: Queue[Int], visited: Set[Int]): Boolean = {
      q.dequeueOption match {
        case None => visited.size == rooms.size
        case Some((x, nq)) => {
          val next = rooms(x).filter(!visited.contains(_))
          search(nq.enqueueAll(next), visited ++ next)
        }
      }
    }
    search(Queue(0), Set(0))
  }
}
// @lc code=end
