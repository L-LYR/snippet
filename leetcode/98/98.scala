/*
 * @lc app=leetcode.cn id=98 lang=scala
 *
 * [98] 验证二叉搜索树
 */
package Q98

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
  def isValidBST(
      root: TreeNode,
      min: Long = Long.MaxValue,
      max: Long = Long.MinValue
  ): Boolean = {
    root == null ||
    (root.value.toLong < min &&
      isValidBST(root.left, root.value.toLong, max)) &&
    (root.value.toLong > max &&
      isValidBST(root.right, min, root.value.toLong))
  }
}
// @lc code=end
