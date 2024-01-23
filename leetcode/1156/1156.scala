/*
 * @lc app=leetcode.cn id=1156 lang=scala
 *
 * [1156] 单字符重复子串的最大长度
 */
package Q1156

// @lc code=start
object Solution {
  def maxRepOpt1(text: String): Int = {
    val m = text.groupMapReduce(identity)(_ => 1)(_ + _)
    val n = text.size
    @annotation.tailrec
    def checkAlternatingFrom(l: Int, len: Int, c: Char): Int = {
      (l + len) match {
        case r if r < n && text(r) == c => checkAlternatingFrom(l, len + 1, c)
        case r                          => r
      }
    }
    @annotation.tailrec
    def loopL(l: Int, ans: Int): Int = {
      if (l == n) {
        ans
      } else {
        val c = text(l)
        val r1 = checkAlternatingFrom(l, 0, c)
        val cc = m.get(c).get
        val cur1 = if (r1 - l < cc && (l > 0 || r1 < n)) r1 - l else 0
        val r2 = checkAlternatingFrom(r1 + 1, 0, c)
        val cur2 = (r2 - l) min cc
        loopL(r1, ans max cur1 max cur2)
      }
    }
    loopL(0, 0)
  }
}
// @lc code=end
