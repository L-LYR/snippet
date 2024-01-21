/*
 * @lc app=leetcode.cn id=169 lang=scala
 *
 * [169] 多数元素
 */
package Q169

// @lc code=start
object Solution {
  def majorityElement(nums: Array[Int]): Int = {
    // https://www.cs.utexas.edu/~moore/best-ideas/mjrty/
    nums
      .foldLeft((nums(0), 0))((acc, x) =>
        acc match {
          case (_, 0) => (x, 1)
          case (y, c) => if (x == y) (y, c + 1) else (y, c - 1)
        }
      )
      ._1
  }
}
// @lc code=end
