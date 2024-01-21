/*
 * @lc app=leetcode.cn id=2744 lang=scala
 *
 * [2744] 最大字符串配对数目
 */
package Q2744

// @lc code=start
object Solution {
  def maximumNumberOfStringPairs(words: Array[String]): Int = {
    val counts =
      words.indices.map { i =>
        val reversed = words(i).reverse
        words.iterator.drop(i + 1).count(_ == reversed)
      }
    counts.sum
  }
}
// @lc code=end
