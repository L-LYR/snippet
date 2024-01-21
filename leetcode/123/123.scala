/*
 * @lc app=leetcode.cn id=123 lang=scala
 *
 * [123] 买卖股票的最佳时机 III
 */
package Q123

// @lc code=start
object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    prices.iterator
      .foldLeft((Int.MinValue, Int.MinValue, 0, 0)) {
        case ((hold0, hold1, sell0, sell1), price) => {
          (
            hold0.max(-price),
            hold1.max(sell0 - price),
            sell0.max(hold0 + price),
            sell1.max(hold1 + price)
          )
        }
      }
      ._4

  }
}
// @lc code=end
