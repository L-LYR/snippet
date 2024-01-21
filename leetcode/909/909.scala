/*
 * @lc app=leetcode.cn id=909 lang=scala
 *
 * [909] 蛇梯棋
 */
package Q909

// @lc code=start
object Solution {
  def snakesAndLadders(board: Array[Array[Int]]): Int = {
    val n = board.size
    val target = n * n
    import scala.collection.immutable.Queue
    def trans(id: Int): (Int, Int) = {
      val r = (id - 1) / n
      val c = (id - 1) % n;
      if (r % 2 == 1) (n - 1 - r, n - 1 - c) else (n - 1 - r, c)
    }
    @annotation.tailrec
    def bfs(q: Queue[(Int, Int)], visited: Set[Int]): Int = {
      q.dequeueOption match {
        case None => -1
        case Some(((id, k), nq)) => {
          val next = (1 to 6)
            .map(_ + id)
            .filter(_ <= n * n)
            .map(id => {
              val (r, c) = trans(id)
              if (board(r)(c) != -1) board(r)(c) else id
            })
            .filter(!visited.contains(_))
          next.find(_ == target) match {
            case None    => bfs(nq.enqueueAll(next.map((_, k + 1))), visited ++ next)
            case Some(_) => k + 1
          }
        }
      }
    }
    bfs(Queue((1, 0)), Set(1))
  }
}
// @lc code=end
