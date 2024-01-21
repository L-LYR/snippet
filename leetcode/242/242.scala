/*
 * @lc app=leetcode.cn id=242 lang=scala
 *
 * [242] 有效的字母异位词
 */
package Q242

// @lc code=start
object Solution {
  def isAnagram(s: String, t: String): Boolean = {
    // s.length == t.length && s.diff(t).isEmpty()
    s.sorted equals t.sorted
  }
}
// @lc code=end
