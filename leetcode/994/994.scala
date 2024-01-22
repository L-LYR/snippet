/*
 * @lc app=leetcode.cn id=994 lang=scala
 *
 * [994] 腐烂的橘子
 */
package Q994

// @lc code=start
object Solution {
  val Empty = 0
  val Fresh = 1
  val Rot = 2
  def orangesRotting(grid: Array[Array[Int]]): Int = {
    val m = grid.size
    val n = grid(0).size
    val ds = Array((0, 1), (0, -1), (1, 0), (-1, 0))
    def rot(): Int = {
      (for {
        i <- grid.indices
        j <- grid(i).indices
        if (grid(i)(j) == Rot)
      } yield ds
        .map { case (x, y) => (x + i, y + j) }
        .filter { case (nx, ny) =>
          nx >= 0 && ny >= 0 && nx < m && ny < n
        }).flatten
        .filter { case (i, j) => grid(i)(j) == Fresh }
        .tapEach { case (i, j) => grid(i)(j) = Rot }
        .size
    }

    val x = Stream.from(1).takeWhile(_ => rot() > 0).lastOption.getOrElse(0)
    if (grid.forall(_.forall(_ != Fresh))) x else -1
  }
}
// @lc code=end
