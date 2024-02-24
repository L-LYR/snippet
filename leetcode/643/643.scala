/*
 * @lc app=leetcode.cn id=643 lang=scala
 *
 * [643] 子数组最大平均数 I
 */
package Q643

// @lc code=start
object Solution {
  def findMaxAverage(nums: Array[Int], k: Int): Double = {
    // nums.iterator.sliding(k).iterator.map(s => s.iterator.map(_.toDouble).sum / k).max

    @annotation.tailrec
    def helper(nums: Array[Int], k: Int, first: Int = 0, max: Int = Int.MinValue)(implicit
        sum: Int = nums.take(k).sum
    ): Double =
      if (first + k >= nums.length) max.max(sum) / k.toDouble
      else helper(nums, k, first + 1, max.max(sum))(sum - nums(first) + nums(first + k))

    helper(nums, k)
  }
}
// @lc code=end
