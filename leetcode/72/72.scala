/*
 * @lc app=leetcode.cn id=72 lang=scala
 *
 * [72] 编辑距离
 */
package Q72

// @lc code=start
object Solution {
  import scala.collection.mutable.HashMap
  def memorize[I, O](f: I => O): I => O = new HashMap[I, O]() {
    override def apply(key: I) = getOrElseUpdate(key, f(key))
  }
  def minDistance(word1: String, word2: String): Int = {
    lazy val dp: ((Int, Int)) => Int = memorize {
      case (0, j)                                 => j
      case (i, 0)                                 => i
      case (i, j) if word1(i - 1) == word2(j - 1) => dp(i - 1, j - 1)
      case (i, j) => (dp(i - 1, j - 1) min dp(i, j - 1) min dp(i - 1, j)) + 1
    }
    dp(word1.size, word2.size)
  }
}
// @lc code=end
