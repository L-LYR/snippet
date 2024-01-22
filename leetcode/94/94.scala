/*
 * @lc app=leetcode.cn id=94 lang=scala
 *
 * [94] 二叉树的中序遍历
 */
package Q94

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

// @lc code=start
object Solution {
  def inorderTraversal(root: TreeNode): List[Int] = {
    if (root == null) {
      List.empty
    } else {
      inorderTraversal(root.left) ++ List(root.value) ++ inorderTraversal(root.right)
    }
  }
}
// @lc code=end
