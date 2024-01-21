/*
 * @lc app=leetcode.cn id=763 lang=scala
 *
 * [763] 划分字母区间
 */
package Q763

// @lc code=start
object Solution {
  def partitionLabels(s: String): List[Int] = {
    val m = ('a' to 'z').map(c => (c, s.lastIndexOf(c))).filter(_._2 != -1).toMap
    def split(l: Int, i: Int, r: Int, ans: List[Int]): List[Int] = {
      if (l == s.size) {
        ans
      } else {
        val nr = r.max(m.get(s(i)).get)
        if (nr == i) {
          split(r + 1, r + 1, r + 1, ans :+ (r - l + 1))
        } else {
          split(l, i + 1, nr, ans)
        }
      }
    }
    split(0, 0, 0, List.empty)
  }
}
// @lc code=end
