/*
 * @lc app=leetcode.cn id=2085 lang=scala
 *
 * [2085] 统计出现过一次的公共字符串
 */
package Q2085

// @lc code=start
object Solution {
  def countWords(words1: Array[String], words2: Array[String]): Int = {
    val counter2 = words2.groupMapReduce(identity)(_ => 1)(_ + _)
    words1
      .groupMapReduce(identity)(_ => 1)(_ + _)
      .count({ case (s, c) => c == 1 && counter2.getOrElse(s, 0) == 1 })
  }
}
// @lc code=end
