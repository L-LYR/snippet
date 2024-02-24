/*
 * @lc app=leetcode.cn id=987 lang=scala
 *
 * [987] 二叉树的垂序遍历
 */
package Q987

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

// @lc code=start
object Solution {
  def verticalTraversal(root: TreeNode): List[List[Int]] = {
    def inorder(node: TreeNode, x: Int, y: Int): List[(Int, Int, Int)] = {
      Option(node) match {
        case None => List.empty
        case Some(node) =>
          inorder(node.left, x + 1, y - 1) ++
            List((node.value, x, y)) ++
            inorder(node.right, x + 1, y + 1)
      }
    }
    inorder(root, 0, 0)
      .groupMap(_._3)(p => (p._1, p._2))
      .toList
      .sortBy(_._1)
      .map { case (_, l) =>
        l.sortWith { case ((lv, lx), (rv, rx)) =>
          lx < rx || (lx == rx && lv < rv)
        }.map(_._1)
      }
  }
}
// @lc code=end
