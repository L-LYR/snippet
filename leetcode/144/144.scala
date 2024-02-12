/*
 * @lc app=leetcode.cn id=144 lang=scala
 *
 * [144] 二叉树的前序遍历
 */
package Q144

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

// @lc code=start
object Solution {
  def preorderTraversal(root: TreeNode): List[Int] = {
    Option(root) match {
      case None => List.empty
      case Some(n) =>
        List(n.value) ++ preorderTraversal(n.left) ++ preorderTraversal(n.right)
    }
  }
}
// @lc code=end
