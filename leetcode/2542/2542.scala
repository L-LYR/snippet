/*
 * @lc app=leetcode.cn id=2542 lang=scala
 *
 * [2542] 最大子序列的分数
 */
package Q2542

// @lc code=start
object Solution {
  def maxScore(nums1: Array[Int], nums2: Array[Int], k: Int): Long = {
    val idx = nums1.indices.sortBy(nums2(_))(Ordering.Int.reverse).toArray
    import scala.collection.mutable.PriorityQueue
    val q = new PriorityQueue()(Ordering.Int.reverse)
    val s = idx.iterator
      .take(k - 1)
      .foldLeft(0.toLong)((acc, i) => {
        q.enqueue(nums1(i))
        acc + nums1(i)
      })
    idx.iterator
      .drop(k - 1)
      .foldLeft((0.toLong, s)) {
        case ((mx, s), i) => {
          q.enqueue(nums1(i))
          (math.max(mx, (s + nums1(i)) * nums2(i)), s + nums1(i) - q.dequeue())
        }
      }
      ._1
  }
}
// @lc code=end
