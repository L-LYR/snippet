/*
 * @lc app=leetcode.cn id=48 lang=scala
 *
 * [48] 旋转图像
 */
package Q48

// @lc code=start
object Solution {
  implicit class ArrayExt(val a: Array[Array[Int]]) extends AnyVal {
    def transposeInPlace: Array[Array[Int]] = {
      for (i <- a.indices; j <- 0 until i) {
        val acc = a(i)(j)
        a(i)(j) = a(j)(i)
        a(j)(i) = acc
      }
      a
    }

    def reverseInPlace: Array[Array[Int]] = {
      for (i <- 0 until a.length / 2) {
        val j = a.length - 1 - i
        val acc = a(i)
        a(i) = a(j)
        a(j) = acc
      }
      a
    }
  }

  def rotate(matrix: Array[Array[Int]]): Unit =
    matrix.reverseInPlace.transposeInPlace
}
// @lc code=end
