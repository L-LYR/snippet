/*
 * @lc app=leetcode.cn id=39 lang=scala
 *
 * [39] 组合总和
 */
package Q39

// @lc code=start
object Solution {
  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    def dfs(i: Int, s: Int, cur: List[Int]): List[List[Int]] = {
      if (s == target) {
        List(cur)
      } else if (s < target) {
        candidates.zipWithIndex
          .drop(i)
          .foldLeft(List.empty[List[Int]])({ case (acc, (x, j)) =>
            acc ::: dfs(j, s + x, cur :+ x)
          })
      } else {
        List.empty
      }
    }
    dfs(0, 0, List.empty)
  }
}
// @lc code=end
