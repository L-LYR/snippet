/*
 * @lc app=leetcode.cn id=104 lang=scala
 *
 * [104] 二叉树的最大深度
 */
package Q104

class TreeNode(
    _value: Int = 0,
    _left: TreeNode = null,
    _right: TreeNode = null
) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

// @lc code=start
object Solution {
  def maxDepth(root: TreeNode): Int = {
    root match {
      case null => 0
      case _    => math.max(maxDepth(root.left), maxDepth(root.right)) + 1
    }
  }
}
// @lc code=end
