/*
 * @lc app=leetcode.cn id=74 lang=scala
 *
 * [74] 搜索二维矩阵
 */
package Q74

// @lc code=start
object Solution {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    val col_size = matrix.length
    val row_size = matrix(0).length

    @annotation.tailrec
    def binarySearch(l: Int, r: Int): Boolean = {
      if (l == r) {
        false
      } else {
        val m = (r - l) / 2 + l;
        val x = matrix(m / row_size)(m % row_size)
        if (x == target) {
          true
        } else if (x < target) {
          binarySearch(m + 1, r)
        } else {
          binarySearch(l, m)
        }
      }
    }

    binarySearch(0, col_size * row_size)
  }
}
// @lc code=end
