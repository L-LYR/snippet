/*
 * @lc app=leetcode.cn id=54 lang=scala
 *
 * [54] 螺旋矩阵
 */
package Q54

// @lc code=start
object Solution {
  val forward = Array((0, 1), (1, 0), (0, -1), (-1, 0))
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    val total = matrix.size * matrix(0).size
    (0 until total)
      .scanLeft((0, 0, 0, 0, 0, matrix.size, 0, matrix(0).size))({
        case ((i, j, k, _, u, d, l, r), _) => {
          val f = forward(k)
          val ni = i + f._1
          val nj = j + f._2
          if (ni < u || nj < l || ni >= d || nj >= r) {
            val nk = (k + 1) % 4
            val nf = forward(nk)
            val ni = i + nf._1
            val nj = j + nf._2
            nk match {
              case 0 => (ni, nj, nk, matrix(i)(j), u, d, l + 1, r)
              case 1 => (ni, nj, nk, matrix(i)(j), u + 1, d, l, r)
              case 2 => (ni, nj, nk, matrix(i)(j), u, d, l, r - 1)
              case 3 => (ni, nj, nk, matrix(i)(j), u, d - 1, l, r)
            }
          } else {
            (ni, nj, k, matrix(i)(j), u, d, l, r)
          }
        }
      })
      .drop(1)
      .map(_._4)
      .toList
  }
}
// @lc code=end
