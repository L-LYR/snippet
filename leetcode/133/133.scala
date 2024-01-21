/*
 * @lc app=leetcode.cn id=133 lang=scala
 *
 * [133] 克隆图
 */
package Q133

class Node(var _value: Int) {
  var value: Int = _value
  var neighbors: List[Node] = List()
}

// @lc code=start
object Solution {
  import scala.collection.mutable.Map
  val visited = Map.empty[Node, Node]
  def cloneGraph(graph: Node): Node = {
    if (graph == null) {
      null
    } else {
      visited.get(graph) match {
        case None => {
          val n = new Node(graph.value)
          visited.addOne((graph, n))
          n.neighbors =
            graph.neighbors.foldLeft(List.empty[Node])((acc, nn) => acc :+ cloneGraph(nn))
          n
        }
        case Some(n) => n
      }
    }
  }
}
// @lc code=end
