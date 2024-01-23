/*
 * @lc app=leetcode.cn id=2765 lang=scala
 *
 * [2765] 最长交替子序列
 */
package Q2765

// @lc code=start
object Solution {
  def alternatingSubarray(nums: Array[Int]): Int = {
    @annotation.tailrec
    def checkAlternatingFrom(l: Int, len: Int = 1, diff: Int = 1): Int = {
      (l + len, diff) match {
        case (r, _) if r == nums.size               => len
        case (r, -1) if nums(r) - nums(r - 1) == -1 => checkAlternatingFrom(l, len + 1, 1)
        case (r, 1) if nums(r) - nums(r - 1) == 1   => checkAlternatingFrom(l, len + 1, -1)
        case _                                      => len
      }
    }
    @annotation.tailrec
    def loop(i: Int, ans: Int): Int = {
      if (i < nums.size) {
        checkAlternatingFrom(i) match {
          case len if len > 1 => loop(i + len - 1, ans max len)
          case _              => loop(i + 1, ans)
        }
      } else { ans }
    }

    loop(0, -1)
  }
}
// @lc code=end
