/*
 * @lc app=leetcode.cn id=700 lang=scala
 *
 * [700] 二叉搜索树中的搜索
 */
package Q700
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}
// @lc code=start
object Solution {
  @annotation.tailrec
  def searchBST(root: TreeNode, value: Int): TreeNode = {
    Option(root) match {
      case None                     => null
      case _ if root.value == value => root
      case _ if root.value < value  => searchBST(root.right, value)
      case _                        => searchBST(root.left, value)
    }
  }
}
// @lc code=end
