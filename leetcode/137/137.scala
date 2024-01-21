/*
 * @lc app=leetcode.cn id=137 lang=scala
 *
 * [137] 只出现一次的数字 II
 */
package Q137

// @lc code=start
object Solution {
  def singleNumber(nums: Array[Int]): Int = {
    nums
      .foldLeft[(Int, Int)]((0, 0))({ case ((a, b), x) =>
        ((a ^ x) & (a | b), (b ^ x) & ~a)
      })
      ._2
  }
}
// @lc code=end
