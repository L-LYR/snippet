/*
 * @lc app=leetcode.cn id=429 lang=scala
 *
 * [429] N 叉树的层序遍历
 */
package Q429
class Node(var _value: Int) {
  var value: Int = _value
  var children: List[Node] = List()
}
// @lc code=start
object Solution {
  def levelOrder(root: Node): List[List[Int]] = {
    Option(root) match {
      case None => List.empty
      case Some(node) =>
        List(List(node.value)) ++ root.children.map(levelOrder(_)).foldLeft(List.empty[List[Int]]) {
          case (r, l) => r.zipAll(l, List.empty[Int], List.empty[Int]).map { case (r, l) => r ++ l }
        }
    }
  }
}
// @lc code=end
