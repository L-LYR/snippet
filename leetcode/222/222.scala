/*
 * @lc app=leetcode.cn id=222 lang=scala
 *
 * [222] 完全二叉树的节点个数
 */

package Q222

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

// @lc code=start
object Solution {
  def countNodes(root: TreeNode): Int = {
    Option(root) match {
      case Some(node) => 1 + countNodes(node.left) + countNodes(node.right)
      case None       => 0
    }
  }
}
// @lc code=end
