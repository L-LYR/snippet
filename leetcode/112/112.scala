/*
 * @lc app=leetcode.cn id=112 lang=scala
 *
 * [112] 路径总和
 */
package Q112

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
  def hasPathSum(root: TreeNode, targetSum: Int): Boolean = {
    root != null && ((root.left == null && root.right == null && root.value == targetSum) ||
      hasPathSum(root.left, targetSum - root.value) ||
      hasPathSum(root.right, targetSum - root.value))
  }
}
// @lc code=end
