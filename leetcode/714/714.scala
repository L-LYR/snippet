/*
 * @lc app=leetcode.cn id=714 lang=scala
 *
 * [714] 买卖股票的最佳时机含手续费
 */
package Q714
// @lc code=start
object Solution {
  def maxProfit(prices: Array[Int], fee: Int): Int = {
    prices.iterator
      .foldLeft((Int.MinValue, 0)) { case ((hold, sell), price) =>
        (hold.max(sell - price - fee), sell.max(hold + price))
      }
      ._2
  }
}
// @lc code=end
