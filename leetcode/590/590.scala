/*
 * @lc app=leetcode.cn id=590 lang=scala
 *
 * [590] N 叉树的后序遍历
 */
package Q590
class Node(var _value: Int) {
  var value: Int = _value
  var children: List[Node] = List()
}
// @lc code=start
object Solution {
  def postorder(root: Node): List[Int] = {
    Option(root) match {
      case None => List.empty
      case Some(node) =>
        node.children.flatMap(postorder(_)).appended(root.value)
    }
  }
}
// @lc code=end
