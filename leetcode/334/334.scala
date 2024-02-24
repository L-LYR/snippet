/*
 * @lc app=leetcode.cn id=334 lang=scala
 *
 * [334] 递增的三元子序列
 */
package Q334

// @lc code=start
object Solution {
  def increasingTriplet(nums: Array[Int]): Boolean = {
    nums.iterator
      .drop(1)
      .foldLeft(List(nums(0))) {
        case (p, x) if x > p.last => p :+ x
        case (p, x) => {
          val i = p.search(x).insertionPoint
          p.take(i) ++ List(x) ++ p.drop(i + 1)
        }
      }
      .length >= 3
  }
}
// @lc code=end
