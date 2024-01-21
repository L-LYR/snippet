/*
 * @lc app=leetcode.cn id=101 lang=scala
 *
 * [101] 对称二叉树
 */
package Q101

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
  def isSymmetric(root: TreeNode): Boolean = {
    def check(p: TreeNode, q: TreeNode): Boolean = {
      (p == null && q == null) ||
      (p != null && q != null && p.value == q.value
        && check(p.left, q.right) && check(p.right, q.left))
    }
    root == null || check(root.left, root.right)
  }
}
// @lc code=end
