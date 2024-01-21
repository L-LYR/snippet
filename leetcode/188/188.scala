/*
 * @lc app=leetcode.cn id=188 lang=scala
 *
 * [188] 买卖股票的最佳时机 IV
 */
package Q188

// @lc code=start
object Solution {
  def maxProfit(k: Int, prices: Array[Int]): Int = {
    prices.iterator
      .foldLeft(
        (List.fill[Int](k)(Int.MinValue), List.fill[Int](k)(0))
      ) { case ((holds, sells), price) =>
        (
          holds.zip(sells.prepended(0).dropRight(1)).map { case (hold, sell) =>
            hold.max(sell - price)
          },
          sells.zip(holds).map { case (sell, hold) =>
            sell.max(hold + price)
          }
        )
      }
      ._2
      .last
  }
}
// @lc code=end
