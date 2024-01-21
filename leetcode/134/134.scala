/*
 * @lc app=leetcode.cn id=134 lang=scala
 *
 * [134] 加油站
 */
package Q134

// @lc code=start
object Solution {
  def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
    val n = gas.size
    @annotation.tailrec
    def find(sp: Int): Int = {
      @annotation.tailrec
      def findFrom(sp: Int, i: Int, gasSum: Int, costSum: Int): Int = {
        if (i < n) {
          val j = (sp + i) % n
          val nGasSum = gasSum + gas(j)
          val nCostSum = costSum + cost(j)
          if (nGasSum < nCostSum) { i }
          else { findFrom(sp, i + 1, nGasSum, nCostSum) }
        } else {
          i
        }
      }
      if (sp < n) {
        val i = findFrom(sp, 0, 0, 0)
        if (i == n) { sp }
        else { find(sp + i + 1) }
      } else {
        -1;
      }
    }

    find(0)
  }
}
// @lc code=end
