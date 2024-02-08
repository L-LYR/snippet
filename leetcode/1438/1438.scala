/*
 * @lc app=leetcode.cn id=1438 lang=scala
 *
 * [1438] 绝对差不超过限制的最长连续子数组
 */
package Q1438

// @lc code=start
object Solution {
  def longestSubarray(nums: Array[Int], limit: Int): Int = {
    @annotation.tailrec
    def loop(r: Int, l: Int, qmn: List[Int], qmx: List[Int], ans: Int, updated: Boolean): Int = {
      (qmn, qmx) match {
        case _ if r == nums.size                           => ans
        case (xs :+ x, _) if !updated && nums(x) <= nums(r) => loop(r, l, xs, qmx, ans, false)
        case (_, xs :+ x) if !updated && nums(x) >= nums(r) => loop(r, l, qmn, xs, ans, false)
        case _ if !updated => loop(r, l, qmn :+ r, qmx :+ r, ans, true)
        case (qmn, qmx) if updated && math.abs(nums(qmx.head) - nums(qmn.head)) > limit => {
          if (qmn.head == l) loop(r, l + 1, qmn.tail, qmx, ans, true)
          else if (qmx.head == l) loop(r, l + 1, qmn, qmx.tail, ans, true)
          else loop(r, l + 1, qmn, qmx, ans, true)
        }
        case _ => loop(r + 1, l, qmn, qmx, ans max (r - l + 1), false)
      }
    }
    loop(0, 0, List.empty, List.empty, 0, false)
  }
}
// @lc code=end
