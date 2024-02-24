/*
 * @lc app=leetcode.cn id=345 lang=scala
 *
 * [345] 反转字符串中的元音字母
 */
package Q345

// @lc code=start
object Solution {
  val isVowel: Set[Char] = Set('a', 'e', 'i', 'o', 'u').flatMap(c => Set(c, c.toUpper))

  def reverseVowels(s: String): String = {
    val as = s.toArray
    @annotation.tailrec
    def helper(l: Int, r: Int): String = {
      if (l >= r) {
        as.mkString
      } else if (!isVowel(as(l))) {
        helper(l + 1, r)
      } else if (!isVowel(as(r))) {
        helper(l, r - 1)
      } else {
        val t = as(l)
        as(l) = as(r)
        as(r) = t
        helper(l + 1, r - 1)
      }
    }
    helper(0, s.length() - 1)
  }
}
// @lc code=end
