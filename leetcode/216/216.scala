/*
 * @lc app=leetcode.cn id=216 lang=scala
 *
 * [216] 组合总和 III
 */
package Q216

// @lc code=start
object Solution {
  def combinationSum3(k: Int, n: Int): List[List[Int]] = {
    (1 to 9).combinations(k).filter(_.sum == n).map(_.toList).toList
  }
}
// @lc code=end
