/*
 * @lc app=leetcode.cn id=69 lang=scala
 *
 * [69] x 的平方根
 */
package Q69

// @lc code=start
object Solution {
  def mySqrt(x: Int): Int = {
    @annotation.tailrec
    def binarySearch(l: Int, r: Int): Int = {
      if (l == r) {
        l
      } else {
        val m = (r - l) / 2 + l + 1;
        if (m.toLong * m.toLong == x.toLong) {
          m
        } else if (m.toLong * m.toLong > x.toLong) {
          binarySearch(l, m - 1)
        } else {
          binarySearch(m, r)
        }
      }
    }
    if (x <= 1) x else binarySearch(1, x / 2)
  }
}
// @lc code=end
