/*
 * @lc app=leetcode.cn id=209 lang=scala
 *
 * [209] 长度最小的子数组
 */
package Q209

// @lc code=start
object Solution {
  def minSubArrayLen(target: Int, nums: Array[Int]): Int = {
    @annotation.tailrec
    def minSliceLen(l: Int, r: Int, s: Int, ans: Int): Int =
      if (s >= target) {
        minSliceLen(l + 1, r, s - nums(l), ans.min(r - l + 1))
      } else if (r < nums.size - 1) {
        minSliceLen(l, r + 1, s + nums(r + 1), ans)
      } else {
        if (ans == Int.MaxValue) 0 else ans
      }

    minSliceLen(0, 0, nums.head, Int.MaxValue)
  }
}
// @lc code=end
