/*
 * @lc app=leetcode.cn id=1657 lang=scala
 *
 * [1657] 确定两个字符串是否接近
 */
package Q1657

// @lc code=start
object Solution {
  def closeStrings(word1: String, word2: String): Boolean = {
    if (word1.size != word2.size) {
      false
    } else {
      val s1 = word1.groupMapReduce(identity)(_ => 1)(_ + _)
      val s2 = word2.groupMapReduce(identity)(_ => 1)(_ + _)
      s1.keys.toSet == s2.keys.toSet && s1.values.toList.sorted == s2.values.toList.sorted
    }

  }
}
// @lc code=end
