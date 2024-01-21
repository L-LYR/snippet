/*
 * @lc app=leetcode.cn id=129 lang=scala
 *
 * [129] 求根节点到叶节点数字之和
 */

package Q129

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
  def sumNumbers(root: TreeNode): Int = {
    def helper(root: TreeNode, s: Int): Int = {
      if (root == null) {
        0
      } else if (root.left == null && root.right == null) {
        10 * s + root.value
      } else {
        helper(root.left, 10 * s + root.value) +
          helper(root.right, 10 * s + root.value)
      }
    }
    helper(root, 0)
  }
}
// @lc code=end
