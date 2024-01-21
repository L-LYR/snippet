/*
 * @lc app=leetcode.cn id=41 lang=scala
 *
 * [41] 缺失的第一个正数
 */
package Q41

// @lc code=start
object Solution {
  def firstMissingPositive(nums: Array[Int]): Int = {
    nums.mapInPlace(n => if (n >= 1 && n <= nums.size) n - 1 else -1)
    @annotation.tailrec
    def swap(i: Int, x: Int) {
      if (x != -1 && nums(i) != nums(x)) {
        nums.update(i, nums(x))
        nums.update(x, x)
        swap(i, nums(i))
      }
    }
    nums.indices
      .tapEach(i => swap(i, nums(i)))
      .filter(i => i != nums(i))
      .minOption
      .getOrElse(nums.size) + 1
  }
}
// @lc code=end
