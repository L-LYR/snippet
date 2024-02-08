/*
 * @lc app=leetcode.cn id=2223 lang=scala
 *
 * [2223] 构造字符串的总得分和
 */
package Q2223

// @lc code=start
object Solution {
  import scala.collection.mutable.ArrayBuffer
  def sumScores(s: String): Long = {
    val n = s.size
    val z = ArrayBuffer.fill(n)(0)
    (1 until n).foldLeft((0, 0)) {
      case ((l, r), i) => {
        val init = z(i - l).min(r - i + 1).max(0)
        Stream
          .from(init)
          .takeWhile(j => i + j < n && s(j) == s(i + j))
          .lastOption
          .map(x => {
            z.update(i, x + 1)
            (i, i + x)
          })
          .orElse({
            z(i) = init
            Some((l, r))
          })
          .get
      }
    }
    z.map(_.toLong).sum + n
  }
}
// @lc code=end
