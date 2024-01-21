/*
 * @lc app=leetcode.cn id=117 lang=scala
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */
package Q117

class Node(var _value: Int) {
  var value: Int = _value
  var left: Node = null
  var right: Node = null
  var next: Node = null
}

// @lc code=start
import scala.collection.mutable.Queue

object Solution {
  def connect(root: Node): Node = {
    if (root == null) return null

    var queue = Queue[Node](root)

    while (queue.length > 0) {

      val numNodesLevel = queue.length
      for (i <- 1 to numNodesLevel) {
        val curr = queue.dequeue

        if (curr.left != null)
          queue += curr.left
        if (curr.right != null)
          queue += curr.right

        if (i < numNodesLevel)
          curr.next = queue.front
      }
    }
    root
  }
}
// @lc code=end
