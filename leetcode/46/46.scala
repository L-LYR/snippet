/*
 * @lc app=leetcode.cn id=46 lang=scala
 *
 * [46] 全排列
 */
package Q46

// @lc code=start
object Solution {
  def permute(nums: Array[Int]): List[List[Int]] = {
    nums.toList.permutations.toList
  }
}
// @lc code=end
