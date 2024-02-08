/*
 * @lc app=leetcode.cn id=993 lang=scala
 *
 * [993] 二叉树的堂兄弟节点
 */
package Q993
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}
// @lc code=start
object Solution {
  def isCousins(root: TreeNode, x: Int, y: Int): Boolean = {
    import scala.collection.mutable.Queue
    def check_child(n: TreeNode, what: Int): Boolean = {
      (n.left != null && n.left.value == what) || (n.right != null && n.right.value == what)
    }
    @annotation.tailrec
    def bfs(layer: Queue[TreeNode]): Boolean = {
      layer.foldLeft((false, false, false, Queue.empty[TreeNode])) {
        case ((_, _, impossible, _), _) if impossible => (false, false, impossible, null)
        case ((has_x, has_y, _, next_layer), node) => {
          next_layer.enqueueAll(Seq(node.left, node.right).filter(_ != null))
          val x_is_child = check_child(node, x)
          val y_is_child = check_child(node, y)
          if (x_is_child && y_is_child) {
            (has_x, has_y, true, next_layer)
          } else {
            (has_x || x_is_child, has_y || y_is_child, false, next_layer)
          }
        }
      } match {
        case (_, _, impossible, _) if impossible         => false
        case (has_x, has_y, _, _) if has_x && has_y      => true
        case (_, _, _, next_layer) if next_layer.isEmpty => false
        case (_, _, _, next_layer)                       => bfs(next_layer)
      }
    }
    bfs(Queue(root))
  }
}
// @lc code=end
