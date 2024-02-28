/*
 * @lc app=leetcode.cn id=875 lang=scala
 *
 * [875] 爱吃香蕉的珂珂
 */
package Q875

// @lc code=start
object Solution {
  def minEatingSpeed(piles: Array[Int], h: Int): Int = {
    @annotation.tailrec
    def bs(l: Int, r: Int): Int = {
      if (l >= r) {
        l
      } else {
        val m = (r - l) / 2 + l
        val x = piles.map(p => (p + m - 1) / m).sum
        if (x <= h) {
          bs(l, m)
        } else {
          bs(m + 1, r)
        }
      }
    }
    bs(1, 1000000000)
  }
}
// @lc code=end
