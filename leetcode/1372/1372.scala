/*
 * @lc app=leetcode.cn id=1372 lang=scala
 *
 * [1372] 二叉树中的最长交错路径
 */
package Q1372
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}
// @lc code=start
object Solution {
  def longestZigZag(root: TreeNode): Int = {
    // StackOverFlowError 56/58
    def dfs(node: TreeNode, fromLeft: Boolean, depth: Int): Int = {
      Option(node) match {
        case None          => depth
        case _ if fromLeft => dfs(node.right, false, depth + 1) max dfs(node.left, true, 0)
        case _             => dfs(node.left, true, depth + 1) max dfs(node.right, false, 0)
      }
    }
    dfs(root.left, true, 0) max dfs(root.right, false, 0)
  }
}
// @lc code=end
