/*
 * @lc app=leetcode.cn id=26 lang=scala
 *
 * [26] 删除有序数组中的重复项
 */
package Q26

// @lc code=start
object Solution {
  def removeDuplicates(nums: Array[Int]): Int = {
    @annotation.tailrec
    def helper(i: Int, j: Int): Int = {
      if (i == nums.length) {
        j
      } else if (nums(i) != nums(j - 1)) {
        nums.update(j, nums(i))
        helper(i + 1, j + 1)
      } else {
        helper(i + 1, j)
      }
    }
    if (nums.length == 1) 1 else helper(1, 1)
  }
}
// @lc code=end
