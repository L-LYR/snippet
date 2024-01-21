/*
 * @lc app=leetcode.cn id=275 lang=scala
 *
 * [275] H 指数 II
 */
package Q275

// @lc code=start
object Solution {
  def hIndex(citations: Array[Int]): Int = {
    @annotation.tailrec
    def helper(l: Int, r: Int): Int = {
      if (l == r) {
        citations.size - l
      } else {
        val m = (r - l) / 2 + l;
        if (citations(m) >= citations.size - m) {
          helper(l, m)
        } else {
          helper(m + 1, r)
        }
      }
    }

    helper(0, citations.size)
  }
}
// @lc code=end
