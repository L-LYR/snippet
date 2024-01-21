/*
 * @lc app=leetcode.cn id=2246 lang=scala
 *
 * [2246] 相邻字符不同的最长路径
 */
package Q2246

// @lc code=start
object Solution {
  def longestPath(parent: Array[Int], s: String): Int = {
    val n = parent.size
    val g =
      parent.iterator.zipWithIndex.drop(1).foldLeft(Map.empty[Int, List[Int]]) { case (g, (p, i)) =>
        g.updatedWith(p)(
          _ match {
            case None    => Some(List(i))
            case Some(l) => Some(l :+ i)
          }
        )
      }
    // TLE 11/142
    def dfs(i: Int): (Int, Int) = {
      g.getOrElse(i, List.empty)
        .foldLeft((0, 0)) { case ((mcp, mcc), n) =>
          val (msp, sc) = dfs(n);
          if (s(n) == s(i)) {
            (mcp.max(msp), mcc)
          } else {
            (mcp.max(msp).max(mcc + sc + 1), mcc.max(sc + 1))
          }
        }
    }
    dfs(0)._1 + 1
  }
}
// @lc code=end
