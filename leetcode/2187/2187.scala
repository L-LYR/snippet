/*
 * @lc app=leetcode.cn id=2187 lang=scala
 *
 * [2187] 完成旅途的最少时间
 */
package Q2187

// @lc code=start
object Solution {
  def minimumTime(time: Array[Int], totalTrips: Int): Long = {
    @annotation.tailrec
    def binarySearch(l: Long, r: Long): Long = {
      if (l == r) {
        l
      } else {
        val m = (r - l) / 2 + l
        val n = time.map(_.toLong).foldLeft(0.toLong) { case (acc, x) =>
          acc + m / x
        }
        if (n < totalTrips) {
          binarySearch(m + 1, r)
        } else {
          binarySearch(l, m)
        }
      }
    }
    binarySearch(1, totalTrips.toLong * time.min.toLong)
  }
}
// @lc code=end
