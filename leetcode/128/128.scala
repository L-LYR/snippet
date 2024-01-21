/*
 * @lc app=leetcode.cn id=128 lang=scala
 *
 * [128] 最长连续序列
 */
package Q128

// @lc code=start
object Solution {
  def longestConsecutive(nums: Array[Int]): Int = {
    val s = nums.toSet
    @annotation.tailrec
    def countSeq(x: Int, len: Int = 0): Int = {
      if (s.contains(x)) countSeq(x + 1, len + 1)
      else len
    }
    s.filter(i => !s.contains(i - 1))
      .map(countSeq(_))
      .maxOption
      .getOrElse(0)
  }
}
// @lc code=end
