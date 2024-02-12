/*
 * @lc app=leetcode.cn id=145 lang=scala
 *
 * [145] 二叉树的后序遍历
 */
package Q145

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

// @lc code=start
object Solution {
  def postorderTraversal(root: TreeNode): List[Int] = {
    Option(root) match {
      case None => List.empty
      case Some(node) =>
        postorderTraversal(node.left) ++ postorderTraversal(node.right) ++ List(node.value)
    }
  }
}
// @lc code=end
