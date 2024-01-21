/*
 * @lc app=leetcode.cn id=438 lang=scala
 *
 * [438] 找到字符串中所有字母异位词
 */
package Q438

// @lc code=start
object Solution {
  def findAnagrams(s: String, p: String): List[Int] = {
    if (s.size < p.size) {
      List.empty
    } else {
      s.sliding(p.size)
        .zipWithIndex
        .collect {
          case (s, i) if s.sorted == p.sorted => i
        }
        .toList
    }
  }
}
// @lc code=end
