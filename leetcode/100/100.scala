/*
 * @lc app=leetcode.cn id=100 lang=scala
 *
 * [100] 相同的树
 */
package Q100

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
  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    (p == null && q == null) ||
    (p != null && q != null && p.value == q.value &&
      isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
  }
}
// @lc code=end
