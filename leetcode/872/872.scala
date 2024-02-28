/*
 * @lc app=leetcode.cn id=872 lang=scala
 *
 * [872] 叶子相似的树
 */
package Q872
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}
// @lc code=start
object Solution {
  def leafSimilar(root1: TreeNode, root2: TreeNode): Boolean = {

    def dfs(p: TreeNode): List[Int] = {
      Option(p) match {
        case None                                                  => List.empty
        case Some(node) if node.left == null && node.right == null => List(node.value)
        case Some(node)                                            => dfs(p.left) ++ dfs(p.right)
      }
    }

    dfs(root1) == dfs(root2)
  }
}
// @lc code=end
