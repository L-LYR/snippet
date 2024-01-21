/*
 * @lc app=leetcode.cn id=66 lang=scala
 *
 * [66] 加一
 */
package Q66

// @lc code=start
object Solution {
  def plusOne(digits: Array[Int]): Array[Int] = {
    val (r, c) = digits
      .foldRight((Array.empty[Int], true)) {
        case (d, (acc, false))          => (d +: acc, false)
        case (d, (acc, true)) if d == 9 => (0 +: acc, true)
        case (d, (acc, true))           => ((d + 1) +: acc, false)
      }

    if (c) { 1 +: r }
    else { r }
  }
}
// @lc code=end
