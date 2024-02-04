/*
 * @lc app=leetcode.cn id=365 lang=scala
 *
 * [365] 水壶问题
 */
package Q365

// @lc code=start
object Solution {
  def canMeasureWater(x: Int, y: Int, z: Int): Boolean = {
    @annotation.tailrec
    def gcd(a: Int, b: Int): Int = {
      if (b == 0) a else gcd(b, a % b)
    }

    x + y >= z && (
      ((x == 0 || y == 0) && (z == 0 || x + y == z)) ||
        z % gcd(x, y) == 0
    )
  }
}
// @lc code=end
