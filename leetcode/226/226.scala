/*
 * @lc app=leetcode.cn id=226 lang=scala
 *
 * [226] 翻转二叉树
 */
package Q226

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
  def invertTree(root: TreeNode): TreeNode = {
    root match {
      case null => root
      case _ => {
        invertTree(root.left)
        invertTree(root.right)
        var t = root.left
        root.left = root.right
        root.right = t
        root
      }
    }
  }
}
// @lc code=end
