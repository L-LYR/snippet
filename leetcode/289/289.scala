/*
 * @lc app=leetcode.cn id=289 lang=scala
 *
 * [289] 生命游戏
 */
package Q289

// @lc code=start
object Solution {
  val neighbors =
    List((-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1))

  val Dead = 0
  val Alive = 1
  val GoDead = 2
  val Reborn = 3

  def gameOfLife(board: Array[Array[Int]]): Unit = {
    val m = board.size
    val n = board(0).size
    for (i <- 0 until m; j <- 0 until n) {
      val nLive = neighbors
        .map(d => (i + d._1, j + d._2))
        .filter(p => p._1 >= 0 && p._2 >= 0 && p._1 < m && p._2 < n)
        .map(p => board(p._1)(p._2))
        .count(p => p == Alive || p == GoDead)
      board(i)(j) match {
        case Alive if nLive < 2 || nLive > 3 => board(i)(j) = GoDead
        case Dead if nLive == 3              => board(i)(j) = Reborn
        case _                               => ()
      }
    }
    for (i <- 0 until m; j <- 0 until n) {
      board(i)(j) match {
        case GoDead => board(i)(j) = Dead
        case Reborn => board(i)(j) = Alive
        case _      => ()
      }
    }
  }
}
// @lc code=end
