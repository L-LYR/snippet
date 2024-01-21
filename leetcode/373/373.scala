/*
 * @lc app=leetcode.cn id=373 lang=scala
 *
 * [373] 查找和最小的 K 对数字
 */
package Q373

// @lc code=start
object Solution {
  import scala.collection.mutable.PriorityQueue
  def kSmallestPairs(
      nums1: Array[Int],
      nums2: Array[Int],
      k: Int
  ): List[List[Int]] = {
    val n = nums1.size
    val m = nums2.size
    val idx = new Array[Int](n)
    val q = new PriorityQueue[(Int, Int)]()(
      Ordering.by[(Int, Int), Int](_._1).reverse
    )
    nums1.zipWithIndex.foreach({ case (x, i) =>
      q.addOne((x + nums2(idx(i)), i))
    })
    @annotation.tailrec
    def helper(result: List[List[Int]]): List[List[Int]] = {
      if (result.size == k) {
        result
      } else {
        val (_, i) = q.dequeue()
        val ok = List(nums1(i), nums2(idx(i)))
        idx.update(i, idx(i) + 1)
        if (idx(i) < m) {
          q.enqueue((nums1(i) + nums2(idx(i)), i))
        }
        helper(result :+ ok)
      }
    }
    helper(List.empty)
  }
}
// @lc code=end
