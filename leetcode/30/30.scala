/*
 * @lc app=leetcode.cn id=30 lang=scala
 *
 * [30] 串联所有单词的子串
 */
package Q30

// @lc code=start
object Solution {
  def findSubstring(s: String, words: Array[String]): List[Int] = {
    val n_word = words.size
    val word_len = words(0).size
    val window_size = n_word * word_len
    val ss = words.groupMapReduce(identity)(_ => 1)(_ + _)
    @annotation.tailrec
    def helper(l: Int, r: Int, cs: Map[String, Int], ans: List[Int]): List[Int] = {
      if (r > s.size) {
        ans
      } else if (r - l < window_size) {
        val nr = r + word_len
        val ncs = cs.updatedWith(s.slice(r, nr))(_.orElse(Some(0)).map(_ + 1))
        helper(l, nr, ncs, ans)
      } else {
        val nl = l + word_len
        val ncs = cs.updatedWith(s.slice(l, nl))(_.filter(_ > 1).map(_ - 1))
        helper(nl, r, ncs, if (cs.equals(ss)) ans :+ l else ans)
      }
    }
    (0 until word_len)
      .flatMap(sp => helper(sp, sp, Map.empty, List.empty))
      .toList
  }
}
// @lc code=end
