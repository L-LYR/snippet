/*
 * @lc app=leetcode.cn id=240 lang=scala
 *
 * [240] 搜索二维矩阵 II
 */
package Q240

// @lc code=start
object Solution {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    def search(i: Int, j: Int): Boolean = {
      if (i < matrix.size && j >= 0) {
        matrix(i)(j) match {
          case x if x == target => true
          case x if x < target  => search(i + 1, j)
          case x if x > target  => search(i, j - 1)
        }
      } else {
        false
      }
    }
    search(0, matrix(0).size - 1)
  }
}
// @lc code=end
