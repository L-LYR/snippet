/*
 * @lc app=leetcode.cn id=202 lang=scala
 *
 * [202] 快乐数
 */
package Q202

// @lc code=start
object Solution {
  def isHappy(n: Int): Boolean = {
    def squareSum(x: Int): Int = x match {
      case 0 => 0
      case _ => (x % 10) * (x % 10) + squareSum(x / 10)
    }

    @annotation.tailrec
    def findCycle(slow: Int, fast: Int): Boolean = {
      if (slow == fast) slow == 1
      else findCycle(squareSum(slow), squareSum(squareSum(fast)))
    }

    findCycle(squareSum(n), squareSum(squareSum(n)))
  }
}
// @lc code=end
