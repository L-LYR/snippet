/*
 * @lc app=leetcode.cn id=938 lang=scala
 *
 * [938] 二叉搜索树的范围和
 */
package Q938
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

// @lc code=start
object Solution {
  def rangeSumBST(root: TreeNode, low: Int, high: Int): Int = {
    Option(root) match {
      case None                            => 0
      case Some(node) if node.value > high => rangeSumBST(root.left, low, high)
      case Some(node) if node.value < low  => rangeSumBST(root.right, low, high)
      case Some(node) =>
        node.value + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high)
    }
  }
}
// @lc code=end
