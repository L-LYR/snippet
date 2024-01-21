/*
 * @lc app=leetcode.cn id=28 lang=scala
 *
 * [28] 找出字符串中第一个匹配项的下标
 */
package Q28

// @lc code=start
object Solution {
  def strStr(haystack: String, needle: String): Int = {
    haystack
      .sliding(needle.length, 1)
      .zipWithIndex
      .collectFirst({ case (`needle`, y) => y })
      .getOrElse(-1)
    // haystack.indexOf(needle)
  }
}
// @lc code=end
