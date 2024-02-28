/*
 * @lc app=leetcode.cn id=2300 lang=scala
 *
 * [2300] 咒语和药水的成功对数
 */
package Q2300

// @lc code=start
object Solution {
  def successfulPairs(spells: Array[Int], potions: Array[Int], success: Long): Array[Int] = {
    val sortedPotions = potions.sorted
    val m = sortedPotions.length
    spells.map { spell =>
      val t = (success + spell - 1) / spell - 1
      m - binarySearch(sortedPotions, t)
    }
  }

  def binarySearch(arr: Array[Int], target: Long): Int = {
    var lo = 0
    var hi = arr.length - 1
    var res = hi + 1
    while (lo <= hi) {
      val mid = lo + (hi - lo) / 2
      if (arr(mid) > target) {
        res = mid
        hi = mid - 1
      } else {
        lo = mid + 1
      }
    }
    res
  }
}
// @lc code=end
