/*
 * @lc app=leetcode.cn id=13 lang=scala
 *
 * [13] 罗马数字转整数
 */
package Q13

// @lc code=start
object Solution {
  val trans: Map[Char, Int] = Map(
    'I' -> 1,
    'V' -> 5,
    'X' -> 10,
    'L' -> 50,
    'C' -> 100,
    'D' -> 500,
    'M' -> 1000
  )

  def romanToInt(s: String): Int = {
    s.map(trans).reverse.scan(0)((a, b) => if (a > b) -b else b).sum
  }
}
// @lc code=end
