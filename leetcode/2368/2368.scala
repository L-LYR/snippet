/*
 * @lc app=leetcode.cn id=2368 lang=scala
 *
 * [2368] 受限条件下可到达节点的数目
 */
package Q2368
// 59/62 StackOverflowError
// @lc code=start
object Solution {
  def reachableNodes(n: Int, edges: Array[Array[Int]], restricted: Array[Int]): Int = {
    val r = restricted.toSet
    val g = edges
      .filter(p => !r.contains(p(0)) && !r.contains(p(1)))
      .flatMap(p => Seq((p(0), p(1)), (p(1), p(0))))
      .groupMapReduce(_._1)(p => List(p._2))(_ ++ _)

    def dfs(x: Int, p: Int): Int = {
      g.getOrElse(x, List.empty).filter(_ != p).foldLeft(1) { case (acc, y) =>
        acc + dfs(y, x)
      }
    }

    dfs(0, -1)
  }
}
// @lc code=end
