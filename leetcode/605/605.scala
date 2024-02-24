/*
 * @lc app=leetcode.cn id=605 lang=scala
 *
 * [605] 种花问题
 */
package Q605

// @lc code=start
object Solution {
  def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
    val cur = flowerbed.prepended(0).appended(0)
    (1 until cur.size - 1).foldLeft(0) {
      case (acc, i) if cur(i - 1) == 0 && cur(i) == 0 && cur(i + 1) == 0 => {
        cur.update(i, 1)
        acc + 1
      }
      case (acc, _) => acc
    } >= n
  }
}
// @lc code=end
