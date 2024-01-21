/*
 * @lc app=leetcode.cn id=322 lang=scala
 *
 * [322] 零钱兑换
 */
package Q322

// @lc code=start
object Solution {
  import scala.collection.mutable.HashMap
  def memorize[I, O](f: I => O): I => O = new HashMap[I, O]() {
    override def apply(key: I) = getOrElseUpdate(key, f(key))
  }
  def coinChange(coins: Array[Int], amount: Int): Int = {
    lazy val dfs: ((Int, Long)) => Long = memorize {
      case (i, c) => {
        if (i < 0) {
          if (c == 0) 0 else Int.MaxValue.toLong
        } else if (coins(i) > c) {
          dfs(i - 1, c)
        } else {
          math.min(dfs(i - 1, c), dfs(i, c - coins(i)) + 1)
        }
      }
    }
    val ans = dfs(coins.size - 1, amount.toLong)
    if (ans >= Int.MaxValue.toLong) -1 else ans.toInt
  }
}
// @lc code=end
