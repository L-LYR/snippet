/*
 * @lc app=leetcode.cn id=450 lang=scala
 *
 * [450] 删除二叉搜索树中的节点
 */
package Q450
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}
// @lc code=start
object Solution {
  def merge(l: TreeNode, r: TreeNode): TreeNode = {
    if (l == null) r
    else if (r == null) l
    else {
      var ptr = l
      while (ptr.right != null) ptr = ptr.right
      ptr.right = r
      l
    }
  }
  def deleteNode(root: TreeNode, key: Int): TreeNode = {
    if (root == null) null
    else if (root.value == key) {
      merge(root.left, root.right)
    } else {
      if (root.value > key) root.left = deleteNode(root.left, key)
      else root.right = deleteNode(root.right, key)
      root
    }
  }
}
// @lc code=end
