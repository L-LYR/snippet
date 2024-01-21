/*
 * @lc app=leetcode.cn id=77 lang=scala
 *
 * [77] 组合
 */
package Q77

// @lc code=start
object Solution {
  def combine(n: Int, k: Int): List[List[Int]] = {
    (1 to n).toList.combinations(k).toList
  }
}
// @lc code=end
