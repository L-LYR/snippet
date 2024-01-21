/*
 * @lc app=leetcode.cn id=12 lang=scala
 *
 * [12] 整数转罗马数字
 */
package Q12

// @lc code=start
object Solution {
  val trans = Array[(Int, String)](
    1000 -> "M",
    900 -> "CM",
    500 -> "D",
    400 -> "CD",
    100 -> "C",
    90 -> "XC",
    50 -> "L",
    40 -> "XL",
    10 -> "X",
    9 -> "IX",
    5 -> "V",
    4 -> "IV",
    1 -> "I"
  )
  def intToRoman(num: Int): String = {
    trans
      .foldLeft(("", num))((acc, t) => {
        val (roman, remain) = acc
        val (x, s) = t
        (roman + s * (remain / x), remain % x)
      })
      ._1
  }
}
// @lc code=end
