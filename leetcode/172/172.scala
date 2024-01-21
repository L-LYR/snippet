/*
 * @lc app=leetcode.cn id=172 lang=scala
 *
 * [172] 阶乘后的零
 */
package Q172

// @lc code=start
object Solution {
  @annotation.tailrec
  def trailingZeroes(n: Int, acc: Int = 0): Int = {
    if (n == 0) { acc }
    else { trailingZeroes(n / 5, acc + (n / 5)) }
  }
}
// @lc code=end
