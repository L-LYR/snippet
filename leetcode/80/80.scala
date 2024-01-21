/*
 * @lc app=leetcode.cn id=80 lang=scala
 *
 * [80] 删除有序数组中的重复项 II
 */
package Q80

// @lc code=start
object Solution {
  def removeDuplicates(nums: Array[Int]): Int = {
    @annotation.tailrec
    def helper(i: Int, j: Int): Int = {
      if (i == nums.size) {
        j
      } else if (nums(i) == nums(j - 1) && nums(i) == nums(j - 2)) {
        helper(i + 1, j)
      } else {
        nums.update(j, nums(i))
        helper(i + 1, j + 1)
      }
    }

    if (nums.size <= 1) nums.size
    else helper(2, 2)
  }
}
// @lc code=end
