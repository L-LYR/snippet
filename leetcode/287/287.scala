/*
 * @lc app=leetcode.cn id=287 lang=scala
 *
 * [287] 寻找重复数
 */
package Q287

// @lc code=start
object Solution {
  def findDuplicate(nums: Array[Int]): Int = {
    @annotation.tailrec
    def helper(i: Int): Unit = {
      val j = nums(i) - 1
      if (nums(j) != j + 1) {
        val t = nums(i)
        nums(i) = nums(j)
        nums(j) = t
        helper(i)
      }
    }
    nums.indices
      .tapEach(i => if (nums(i) != i + 1) { helper(i) })
      .filter(i => nums(i) != i + 1)
      .map(nums(_))
      .head
  }
}
// @lc code=end
