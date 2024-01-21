/*
 * @lc app=leetcode.cn id=213 lang=scala
 *
 * [213] 打家劫舍 II
 */
package Q213

// @lc code=start
object Solution {

  def rob(nums: Array[Int]): Int = {
    nums.size match {
      case 1 => nums(0)
      case 2 => math.max(nums(0), nums(1))
      case n =>
        math.max(
          rob1(nums.slice(0, n - 1)),
          rob1(nums.slice(1, n))
        )
    }
  }
  def rob1(nums: Array[Int]): Int = {
    nums.size match {
      case 1 => nums(0)
      case _ =>
        nums
          .drop(2)
          .foldLeft((nums(0), math.max(nums(0), nums(1)))) { case ((pp, p), x) =>
            (p, math.max(x + pp, p))
          }
          ._2
    }
  }
}
// @lc code=end
