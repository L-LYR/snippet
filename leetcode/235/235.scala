/*
 * @lc app=leetcode.cn id=235 lang=scala
 *
 * [235] 二叉搜索树的最近公共祖先
 */
package Q235
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}
// @lc code=start
object Solution {
  def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {

    @annotation.tailrec
    def helper(a: TreeNode): TreeNode = {
      if (a.value > p.value && a.value > q.value) {
        helper(a.left)
      } else if (a.value < p.value && a.value < q.value) {
        helper(a.right)
      } else {
        a
      }
    }

    helper(root)
  }
}
// @lc code=end
