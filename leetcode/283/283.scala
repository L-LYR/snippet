/*
 * @lc app=leetcode.cn id=283 lang=scala
 *
 * [283] 移动零
 */
package Q283

// @lc code=start
object Solution {
    def moveZeroes(nums: Array[Int]): Unit = {
        val (zero, nonZero) = nums.partition(_ == 0)
        val res =  nonZero ++ zero
        Array.copy(res, 0, nums, 0, res.size)
    }
}
// @lc code=end

