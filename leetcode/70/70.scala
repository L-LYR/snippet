/*
 * @lc app=leetcode.cn id=70 lang=scala
 *
 * [70] 爬楼梯
 */
package Q70

// @lc code=start
object Solution {
  def climbStairs(n: Int): Int = {
    if (n != 1) {
      (1 until n)
        .foldLeft((1, 1))({ case ((a, b), _) => (b, a + b) })
        ._2
    } else { 1 }
  }
}
// @lc code=end
