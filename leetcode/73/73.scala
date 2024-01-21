/*
 * @lc app=leetcode.cn id=73 lang=scala
 *
 * [73] 矩阵置零
 */
package Q73

// @lc code=start
object Solution {
  def setZeroes(matrix: Array[Array[Int]]): Unit = {
    val m = matrix.size;
    val n = matrix(0).size;
    var zero_col = false;
    for (i <- 0 until m) {
      if (matrix(i)(0) == 0) {
        zero_col = true;
      }
      for (j <- 1 until n) {
        if (matrix(i)(j) == 0) {
          matrix(i)(0) = 0;
          matrix(0)(j) = 0;
        }
      }
    }
    for (i <- m - 1 to 0 by -1) {
      for (j <- 1 until n) {
        if (matrix(i)(0) == 0 || matrix(0)(j) == 0) {
          matrix(i)(j) = 0;
        }
      }
      if (zero_col) {
        matrix(i)(0) = 0;
      }

    }
  }
}
// @lc code=end
