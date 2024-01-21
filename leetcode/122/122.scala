/*
 * @lc app=leetcode.cn id=122 lang=scala
 *
 * [122] 买卖股票的最佳时机 II
 */
package Q122

// @lc code=start
object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    prices.iterator
      .foldLeft((Int.MinValue, 0)) { case ((hold, sell), price) =>
        (hold.max(sell - price), sell.max(hold + price))
      }
      ._2
  }
}
// @lc code=end
