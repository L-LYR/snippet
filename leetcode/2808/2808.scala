/*
 * @lc app=leetcode.cn id=2808 lang=scala
 *
 * [2808] 使循环数组所有元素相等的最少秒数
 */
package Q2808

// @lc code=start
object Solution {
  import scala.collection.immutable.Queue
  def minimumSeconds(nums: List[Int]): Int = {
    val size = nums.size
    nums.iterator.zipWithIndex
      .foldLeft(Map.empty[Int, Queue[Int]]) { case (pos, (num, ind)) =>
        pos.updated(num, pos.getOrElse(num, Queue.empty) :+ ind)
      }
      .map { case (_, pos) => pos.appended(pos(0) + size).sliding(2).map(s => s(1) - s(0)).max }
      .min / 2
  }
}
// @lc code=end
