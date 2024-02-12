/*
 * @lc app=leetcode.cn id=589 lang=scala
 *
 * [589] N 叉树的前序遍历
 */
package Q589

class Node(var _value: Int) {
  var value: Int = _value
  var children: List[Node] = List()
}

// @lc code=start
object Solution {
  def preorder(root: Node): List[Int] = {
    Option(root) match {
      case None => List.empty
      case Some(node) =>
        node.children.flatMap(preorder(_)).prepended(root.value)
    }
  }
}
// @lc code=end
