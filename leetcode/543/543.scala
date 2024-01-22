/*
 * @lc app=leetcode.cn id=543 lang=scala
 *
 * [543] 二叉树的直径
 */
package Q543

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}
// @lc code=start
object Solution {
  def diameterOfBinaryTree(root: TreeNode): Int = {
    def dfs(root: TreeNode): (Int, Int) = {
      if (root == null) {
        (0, 0)
      } else {
        val (lc, lm) = dfs(root.left)
        val (rc, rm) = dfs(root.right)
        ((lc max rc) + 1, lm max rm max (lc + rc + 1))
      }
    }

    dfs(root)._2 - 1
  }
}
// @lc code=end
