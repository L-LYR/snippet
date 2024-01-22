/*
 * @lc app=leetcode.cn id=347 lang=scala
 *
 * [347] 前 K 个高频元素
 */
package Q347

// @lc code=start
object Solution {
  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
    // import scala.collection.mutable.PriorityQueue
    // val q = new PriorityQueue[(Int, Int)]()(Ordering.by(_._1))
    // nums.groupMapReduce(identity)(_ => 1)(_ + _).foreach(p => q.addOne((p._2, p._1)))
    // (1 to k).map(_ => q.dequeue()._2).toArray
    nums.toList
      .groupBy(identity)
      .mapValues(_.size)
      .toList
      .sortBy(-_._2)
      .take(k)
      .map(_._1)
      .toArray
  }
}
// @lc code=end
