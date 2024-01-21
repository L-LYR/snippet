/*
 * @lc app=leetcode.cn id=97 lang=scala
 *
 * [97] 交错字符串
 */
package Q97
// @lc code=start
object Solution {
  import scala.collection.mutable.HashMap
  def memorize[I, O](f: I => O): I => O = new HashMap[I, O]() {
    override def apply(key: I) = getOrElseUpdate(key, f(key))
  }
  def isInterleave(s1: String, s2: String, s3: String): Boolean = {
    lazy val dp: ((Int, Int)) => Boolean = memorize {
      case (i, j) if i == s1.length && j == s2.length => true
      case (i, j) if i == s1.length                   => s2(j) == s3(i + j) && dp(i, j + 1)
      case (i, j) if j == s2.length                   => s1(i) == s3(i + j) && dp(i + 1, j)
      case (i, j) => (s2(j) == s3(i + j) && dp(i, j + 1)) || (s1(i) == s3(i + j) && dp(i + 1, j))
    }
    (s1.length + s2.length == s3.length) && dp(0, 0)
  }
}
// @lc code=end
