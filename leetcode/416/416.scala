/*
 * @lc app=leetcode.cn id=416 lang=scala
 *
 * [416] 分割等和子集
 */
package Q416

// @lc code=start
object Solution {
  def canPartition(nums: Array[Int]): Boolean = {
    val s = nums.sum
    if (s % 2 == 1) {
      false
    } else {
      val f = Array.fill(nums.size + 1, s / 2 + 1)(false)
      f(0)(0) = true
      for {
        i <- 1 to nums.size
        j <- 1 to s / 2
      } {
        if (j < nums(i - 1)) {
          f(i)(j) = f(i - 1)(j)
        } else {
          f(i)(j) = f(i - 1)(j) || f(i - 1)(j - nums(i - 1))
        }
      }

      f(nums.size)(s / 2)
    }
  }
}
// @lc code=end
