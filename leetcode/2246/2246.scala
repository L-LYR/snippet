/*
 * @lc app=leetcode.cn id=2246 lang=scala
 *
 * [2246] 相邻字符不同的最长路径
 */
package Q2246

// @lc code=start
object Solution {
  import scala.collection.mutable.HashMap
  import scala.collection.mutable.Map

  def memorize[I, O](f: I => O): I => O = new HashMap[I, O]() {
    override def apply(key: I) = getOrElseUpdate(key, f(key))
  }

  def longestPath(parent: Array[Int], s: String): Int = {
    // val g =
    //   parent.iterator.zipWithIndex.drop(1).foldLeft(Map.empty[Int, List[Int]]) { case (g, (p, i)) =>
    //     g.updatedWith(p) {
    //       case None    => Some(List(i))
    //       case Some(l) => Some(l :+ i)
    //     }
    //   }
    val g = Map.empty[Int, List[Int]].withDefaultValue(List.empty)
    parent.indices.drop(1).foreach(i => g(parent(i)) ::= i)
    // def dfs(i: Int): (Int, Int) = {
    lazy val dfs: (Int) => (Int, Int) = memorize { i =>
      g.getOrElse(i, List.empty)
        .iterator
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
    // import scala.collection.mutable.Map
    // val g = Map.empty[Int, List[Int]].withDefaultValue(List.empty)
    // parent.indices.foreach(i => g(parent(i)) ::= i)
    // def dfs(i: Int): (Int, Int) = {
    //   val nodeChar = s(i)
    //   g.get(i) match {
    //     case None => (1, 1)
    //     case Some(children) =>
    //       val (closed, open) = children.map(dfs).unzip
    //       val unitable =
    //         open.zip(children).filter(pair => s(pair._2) != nodeChar).map(_._1).sorted.reverse
    //       (math.max(closed.max, unitable.take(2).sum + 1), unitable.take(1).sum + 1)
    //   }
    // }
    // dfs(0)._1
  }
}
// @lc code=end
