/*
 * @lc app=leetcode.cn id=2861 lang=scala
 *
 * [2861] 最大合金数
 */
package Q2861

// @lc code=start
object Solution {
  def maxNumberOfAlloys(
      n: Int,
      k: Int,
      budget: Int,
      composition: List[List[Int]],
      stock: List[Int],
      cost: List[Int]
  ): Int = {
    val mx = stock.min + budget
    composition.foldLeft(0) {
      case (ans, comp) => {

        def check(x: Long): Boolean = {
          comp.lazyZip(stock).lazyZip(cost).foldLeft(0.toLong) {
            case (acc, (j, s, c)) if j * x > s => acc + (j * x - s) * c
            case (acc, _)                      => acc
          } <= budget
        }

        @annotation.tailrec
        def binarySearch(l: Int, r: Int): Int = {
          if (l + 1 == r) {
            l
          } else {
            val m = (r - l) / 2 + l;
            if (check(m)) {
              binarySearch(m, r)
            } else {
              binarySearch(l, m)
            }
          }
        }

        binarySearch(ans, mx + 1)
      }
    }
  }
}
// @lc code=end
