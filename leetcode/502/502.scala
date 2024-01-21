/*
 * @lc app=leetcode.cn id=502 lang=scala
 *
 * [502] IPO
 */
package Q502

// @lc code=start
object Solution {
  def findMaximizedCapital(
      k: Int,
      w: Int,
      profits: Array[Int],
      capital: Array[Int]
  ): Int = {
    import scala.collection.mutable.PriorityQueue
    val p = capital.zip(profits).sortBy(_._1)
    val q = PriorityQueue[Int]()
    @annotation.tailrec
    def helper(i: Int, n: Int, got: Int): Int = {
      if (n == k) {
        got
      } else if (i < p.length && p(i)._1 <= got) {
        q.enqueue(p(i)._2)
        helper(i + 1, n, got)
      } else if (q.length == 0) {
        got
      } else {
        helper(i, n + 1, got + q.dequeue())
      }
    }
    helper(0, 0, w)
  }
}
// @lc code=end
