/*
 * @lc app=leetcode.cn id=2859 lang=scala
 *
 * [2859] 计算 K 置位下标对应元素的和
 */
package Q2859

// @lc code=start
object Solution {
  def sumIndicesWithKSetBits(nums: List[Int], k: Int): Int = {
    nums.iterator.zipWithIndex.collect { case (x, i) if Integer.bitCount(i) == k => x }.sum
  }
}
// @lc code=end
