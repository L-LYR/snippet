/*
 * @lc app=leetcode.cn id=1207 lang=scala
 *
 * [1207] 独一无二的出现次数
 */
package Q1207

// @lc code=start
object Solution {
  def uniqueOccurrences(arr: Array[Int]): Boolean = {
    val m = arr.groupMapReduce(identity)(_ => 1)(_ + _)
    m.size == m.values.toSet.size
  }
}
// @lc code=end
