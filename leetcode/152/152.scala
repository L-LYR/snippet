/*
 * @lc app=leetcode.cn id=152 lang=scala
 *
 * [152] 乘积最大子数组
 */
package Q152

// @lc code=start
object Solution {
  def maxProduct(nums: Array[Int]): Int = {
    nums
      .foldLeft((Int.MinValue, 1, 1)) {
        case ((ans, mx, mn), x) if x > 0 => {
          val nmx = x max (x * mx)
          val nmn = x min (x * mn)
          (nmx max ans, nmx, nmn)
        }
        case ((ans, mx, mn), x) => {
          val nmx = x max (x * mn)
          val nmn = x min (x * mx)
          (nmx max ans, nmx, nmn)
        }
      }
      ._1
  }
}
// @lc code=end
