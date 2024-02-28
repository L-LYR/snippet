/*
 * @lc app=leetcode.cn id=790 lang=scala
 *
 * [790] 多米诺和托米诺平铺
 */
package Q790

// @lc code=start
object Solution {
  val Mod = 1_000_000_007
  implicit class ModIntOps(val n: Int) extends AnyVal {
    def +%(n2: Int): Int = (n + n2) % Mod
  }

  def numTilings(n: Int): Int = {
    @annotation.tailrec
    def tilings(i: Int, sum3: Int, i2: Int, i1: Int): Int =
      if (i == n + 1) i1
      else tilings(i + 1, sum3 +% i2, i1, i1 +% i2 +% sum3 +% sum3 +% 2) // 2 * (sum3 + 1)

    if (n <= 2) n else tilings(3, 0, 1, 2)
  }
}
// @lc code=end
