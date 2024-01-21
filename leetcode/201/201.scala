/*
 * @lc app=leetcode.cn id=201 lang=scala
 *
 * [201] 数字范围按位与
 */
package Q201

// @lc code=start
object Solution {
  def rangeBitwiseAnd(left: Int, right: Int): Int = {
    @annotation.tailrec
    def and(r: Int, result: Int): Int =
      if (r < left) result else and(r - 1, result & r)
    and(right - 1, right)
  }
}
// @lc code=end
