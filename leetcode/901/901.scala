/*
 * @lc app=leetcode.cn id=901 lang=scala
 *
 * [901] 股票价格跨度
 */
package Q901

// @lc code=start
class StockSpanner() {
  import scala.collection.mutable.Stack
  val s = Stack.empty[(Int, Int)]
  def next(price: Int): Int = {
    val n = s.popWhile { case (p, n) => p <= price }.foldLeft(1) { case (acc, (_, n)) => acc + n }
    s.push((price, n))
    n
  }
}
// @lc code=end
