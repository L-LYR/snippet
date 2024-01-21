/*
 * @lc app=leetcode.cn id=3 lang=scala
 *
 * [3] 无重复字符的最长子串
 */
package Q3

// @lc code=start
object Solution {
  def lengthOfLongestSubstring(s: String): Int = {
    @annotation.tailrec
    def helper(l: Int, r: Int, counter: Map[Char, Int], ans: Int): Int = {
      if (counter.exists(_._2 > 1)) {
        helper(l + 1, r, counter.updated(s(l), counter.get(s(l)).get - 1), ans)
      } else if (r == s.size - 1) {
        ans.max(r - l + 1)
      } else {
        helper(
          l,
          r + 1,
          counter.updated(s(r + 1), counter.getOrElse(s(r + 1), 0) + 1),
          ans.max(r - l + 1)
        )
      }
    }

    if (s.size == 0) 0 else helper(0, 0, Map(s(0) -> 1), 1)
  }
}
// @lc code=end
