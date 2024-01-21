/*
 * @lc app=leetcode.cn id=228 lang=scala
 *
 * [228] 汇总区间
 */
package Q228

// @lc code=start
object Solution {
  def summaryRanges(nums: Array[Int]): List[String] = {
    val s = nums.map(_.toLong).toSet
    @annotation.tailrec
    def helper(x: Long): Long = {
      if (s.contains(x + 1)) helper(x + 1)
      else x
    }
    nums
      .map(_.toLong)
      .filter(x => !s.contains(x - 1))
      .map(x =>
        helper(x) match {
          case y if y == x => x.toString
          case y           => x.toString + "->" + y.toString
        }
      )
      .toList
  }
}
// @lc code=end
