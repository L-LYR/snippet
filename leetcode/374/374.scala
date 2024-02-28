/*
 * @lc app=leetcode.cn id=374 lang=scala
 *
 * [374] 猜数字大小
 */
package Q374

// @lc code=start
class Solution extends GuessGame {
  def guessNumber(n: Int): Int = {
    @annotation.tailrec
    def bsNumber(first: Int, end: Int): Int = {
      val half = first + (end - first) / 2
      guess(half) match {
        case -1 => bsNumber(first, half)
        case 1  => bsNumber(half + 1, end)
        case 0  => half
      }
    }

    bsNumber(1, n + 1)
  }
}
// @lc code=end
