/*
 * @lc app=leetcode.cn id=309 lang=scala
 *
 * [309] 买卖股票的最佳时机含冷冻期
 */
package Q309

// @lc code=start
object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    prices.iterator
      .foldLeft((Int.MinValue, 0, 0)) {
        case ((hold, selly, sell), price) => {
          (hold.max(selly - price), sell, sell.max(hold + price))
        }
      }
      ._3
  }
}
// @lc code=end
