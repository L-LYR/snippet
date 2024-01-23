/*
 * @lc app=leetcode.cn id=8 lang=scala
 *
 * [8] 字符串转换整数 (atoi)
 */
package Q8

// @lc code=start
object Solution {
  def myAtoi(str: String): Int = {
    @annotation.tailrec
    def inner(remain: List[Char], x: Int, sign: Option[Char]): Int =
      remain match {
        case ' ' :: rest if sign.isEmpty => inner(rest, x, sign)
        case '-' :: rest if sign.isEmpty => inner(rest, x, Some('-'))
        case '+' :: rest if sign.isEmpty => inner(rest, x, Some('+'))
        case char :: rest if char >= '0' && char <= '9' =>
          val units = char - '0'
          if (
            sign.contains('+') && (x == Int.MaxValue / 10 && units > 7 || x > Int.MaxValue / 10)
          ) {
            Int.MaxValue
          } else if (
            sign.contains('-') && (x == Int.MaxValue / 10 && units >= 8 || x > Int.MaxValue / 10)
          ) {
            Int.MinValue
          } else { inner(rest, x * 10 + units, sign.orElse(Some('+'))) }
        case _ => if (sign.contains('-')) -x else x
      }

    inner(str.toList, 0, None)
  }
}
// @lc code=end
