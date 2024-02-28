/*
 * @lc app=leetcode.cn id=2462 lang=scala
 *
 * [2462] 雇佣 K 位工人的总代价
 */
package Q2462

// @lc code=start
object Solution {
  def totalCost(costs: Array[Int], k: Int, candidates: Int): Long = {
    if (candidates * 2 >= costs.size) {
      costs.sortInPlace().take(k).map(_.toLong).sum
    } else {
      import scala.collection.mutable.PriorityQueue
      val n = costs.size
      val q = new PriorityQueue()(
        Ordering
          .by[Int, Int]((i: Int) => costs(i))
          .reverse
          .orElse(Ordering.Int.reverse)
      )
      q.addAll(0 until candidates).addAll(n - candidates until n)
      (0 until k)
        .foldLeft((candidates, n - 1 - candidates, 0.toLong)) {
          case ((l, r, s), _) if l <= r => {
            val i = q.dequeue()
            val ns = s + costs(i)
            if (i < l) {
              q.addOne(l)
              (l + 1, r, ns)
            } else {
              q.addOne(r)
              (l, r - 1, ns)
            }
          }
          case ((l, r, s), _) => (l, r, s + costs(q.dequeue()))
        }
        ._3
    }
  }
}
// @lc code=end
