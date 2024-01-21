/*
 * @lc app=leetcode.cn id=167 lang=scala
 *
 * [167] 两数之和 II - 输入有序数组
 */
package Q167

// @lc code=start
object Solution {
  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    @annotation.tailrec
    def helper(l: Int, r: Int): Array[Int] = {
      if (l == r) {
        Array.empty
      } else {
        val s = numbers(l) + numbers(r)
        if (s == target) {
          Array(l + 1, r + 1)
        } else if (s < target) {
          helper(l + 1, r)
        } else {
          helper(l, r - 1)
        }
      }
    }
    helper(0, numbers.size - 1)
  }
}
// @lc code=end
