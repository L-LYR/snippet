/*
 * @lc app=leetcode.cn id=121 lang=scala
 *
 * [121] 买卖股票的最佳时机
 */
package Q121

// @lc code=start
object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    prices.iterator
      .foldLeft((Int.MinValue, 0)) { case ((hold, sell), price) =>
        (hold.max(-price), sell.max(hold + price))
      }
      ._2
  }
}
// @lc code=end
