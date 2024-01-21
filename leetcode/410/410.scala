/*
 * @lc app=leetcode.cn id=410 lang=scala
 *
 * [410] 分割数组的最大值
 */
package Q410

// @lc code=start
object Solution {
  def splitArray(nums: Array[Int], k: Int): Int = {
    @annotation.tailrec
    def binarySearch(l: Int, r: Int): Int = {
      if (l == r) {
        l
      } else {
        val m = (r - l) / 2 + l
        val nk = nums
          .foldLeft((0, 0)) { case ((acc, cnt), x) =>
            acc match {
              case _ if acc + x > m => (x, cnt + 1)
              case _                => (acc + x, cnt)
            }
          }
          ._2
        if (nk < k) {
          binarySearch(l, m)
        } else {
          binarySearch(m + 1, r)
        }
      }
    }
    binarySearch(nums.max, nums.sum)
  }
}
// @lc code=end
