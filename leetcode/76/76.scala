/*
 * @lc app=leetcode.cn id=76 lang=scala
 *
 * [76] 最小覆盖子串
 */
package Q76

// @lc code=start
object Solution {
  def minWindow(s: String, t: String): String = {
    val mt = t.groupMapReduce(identity)(_ => 1)(_ + _)
    @annotation.tailrec
    def helper(l: Int, r: Int, ms: Map[Char, Int], ans: Int, i: Int): String = {
      def ok(): Boolean = mt.forall { case (c, n) => ms.getOrElse(c, 0) >= n }
      if (ok()) {
        val nms = ms.updatedWith(s(l))(_.filter(_ > 1).map(_ - 1))
        if (r - l < ans) {
          helper(l + 1, r, nms, r - l, l)
        } else {
          helper(l + 1, r, nms, ans, i)
        }
      } else if (r < s.size) {
        val nms = ms.updatedWith(s(r))(_.orElse(Some(0)).map(_ + 1))
        helper(l, r + 1, nms, ans, i)
      } else {
        if (i == Int.MinValue) "" else s.slice(i, i + ans)
      }
    }
    helper(0, 0, Map.empty, Int.MaxValue, Int.MinValue)
  }
}
// @lc code=end
