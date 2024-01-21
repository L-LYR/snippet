/*
 * @lc app=leetcode.cn id=27 lang=scala
 *
 * [27] 移除元素
 */
package Q27

// @lc code=start
object Solution {
  def removeElement(nums: Array[Int], v: Int): Int = {
    @annotation.tailrec
    def helper(i: Int, j: Int): Int = {
      if (i <= j) {
        if (nums(i) == v) {
          nums.update(i, nums(j))
          helper(i, j - 1)
        } else {
          helper(i + 1, j)
        }
      } else {
        j + 1
      }
    }

    helper(0, nums.length - 1)
  }
}
// @lc code=end
