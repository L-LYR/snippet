/*
 * @lc app=leetcode.cn id=75 lang=scala
 *
 * [75] 颜色分类
 */
package Q75

// @lc code=start
object Solution {
  def sortColors(nums: Array[Int]): Unit = {
    @annotation.tailrec
    def helper(l: Int, r: Int, i: Int): Unit = {
      if (i <= r) {
        val t = nums(i)
        nums(i) match {
          case 0 => {
            nums(i) = nums(l)
            nums(l) = t
            helper(l + 1, r, i + 1)
          }
          case 2 => {
            nums(i) = nums(r)
            nums(r) = t
            helper(l, r - 1, i)
          }
          case _ => helper(l, r, i + 1)
        }
      }
    }
    helper(0, nums.size - 1, 0)
  }
}
// @lc code=end
