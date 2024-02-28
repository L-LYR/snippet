/*
 * @lc app=leetcode.cn id=1448 lang=scala
 *
 * [1448] 统计二叉树中好节点的数目
 */
package Q1448
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

// @lc code=start
object Solution {
  def goodNodes(root: TreeNode): Int = {
    def dfs(root: TreeNode, mx: Int): Int = {
      Option(root) match {
        case None => 0
        case Some(node) if mx <= node.value =>
          1 + dfs(node.left, node.value) + dfs(node.right, node.value)
        case Some(node) => dfs(node.left, mx) + dfs(node.right, mx)
      }
    }
    dfs(root, Int.MinValue)
  }
}
// @lc code=end
