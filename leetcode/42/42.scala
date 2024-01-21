/*
 * @lc app=leetcode.cn id=42 lang=scala
 *
 * [42] 接雨水
 */
package Q42

// @lc code=start
object Solution {
  def trap(height: Array[Int]): Int = {
    val prefix_max_height = height.scanLeft(0)((h, x) => h.max(x)).drop(1)
    val suffix_max_height = height.scanRight(0)((x, h) => h.max(x)).dropRight(1)
    prefix_max_height.zip(suffix_max_height).zip(height).foldLeft(0) { case (acc, ((l, r), h)) =>
      acc + l.min(r) - h
    }
  }
}
// @lc code=end
