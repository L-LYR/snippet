/*
 * @lc app=leetcode.cn id=236 lang=scala
 *
 * [236] 二叉树的最近公共祖先
 */

package Q236

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

// @lc code=start
object Solution {
  def lowestCommonAncestor(
      root: TreeNode,
      p: TreeNode,
      q: TreeNode
  ): TreeNode = {
    if (root == null || root == p || root == q) {
      root
    } else {
      val left = lowestCommonAncestor(root.left, p, q);
      val right = lowestCommonAncestor(root.right, p, q);
      if (left != null && right != null) {
        root
      } else if (left != null) {
        left
      } else {
        right
      }
    }
  }
}
// @lc code=end
