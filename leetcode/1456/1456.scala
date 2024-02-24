/*
 * @lc app=leetcode.cn id=1456 lang=scala
 *
 * [1456] 定长子串中元音的最大数目
 */
package Q1456

// @lc code=start
object Solution {
  def maxVowels(s: String, k: Int): Int = {
    // s.iterator
    //   .sliding(k)
    //   .iterator
    //   .map(s => s.count(c => c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'))
    //   .max

    def isVowel(c: Char): Int = {
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') 1 else 0
    }

    @annotation.tailrec
    def helper(first: Int = 0, max: Int = Int.MinValue)(implicit
        sum: Int = s.take(k).map(isVowel(_)).sum
    ): Int =
      if (first + k >= s.length) max.max(sum)
      else helper(first + 1, max.max(sum))(sum - isVowel(s(first)) + isVowel(s(first + k)))

    helper()
  }
}
// @lc code=end
