/*
 * @lc app=leetcode.cn id=1679 lang=scala
 *
 * [1679] K 和数对的最大数目
 */
package Q1679

// @lc code=start
object Solution {
  def maxOperations(nums: Array[Int], k: Int): Int = {
    val cnt = nums.groupMapReduce(identity)(_ => 1)(_ + _)
    cnt.keysIterator
      .foldLeft((0, cnt)) {
        case ((acc, cnt), x) if k - x == x => {
          val n = cnt.getOrElse(x, 0)
          (acc + n / 2, cnt.updated(x, n % 2))
        }
        case ((acc, cnt), x) if cnt.contains(k - x) => {
          val xc = cnt.getOrElse(x, 0)
          val yc = cnt.getOrElse(k - x, 0)
          val n = xc min yc
          (acc + n, cnt.updated(x, xc - n).updated(k - x, yc - n))
        }
        case (s, _) => s
      }
      ._1
  }
}
// @lc code=end
