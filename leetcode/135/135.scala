/*
 * @lc app=leetcode.cn id=135 lang=scala
 *
 * [135] 分发糖果
 */
package Q135

// @lc code=start
object Solution {
  def candy(ratings: Array[Int]): Int = {
    if (ratings.length == 1) { 1 }
    else {
      val L = ratings
        .sliding(2)
        .scanLeft(1)((acc, n) => {
          n match {
            case _ @Array(i, j) if i < j => acc + 1
            case _                       => 1
          }
        })
      val R = ratings
        .sliding(2)
        .scanRight(1)((n, acc) => {
          n match {
            case _ @Array(i, j) if i > j => acc + 1
            case _                       => 1
          }
        })
      L.zip(R).map { case (l, r) => l.max(r) }.sum
    }
  }
}
// @lc code=end
