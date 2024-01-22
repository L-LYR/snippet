/*
 * @lc app=leetcode.cn id=437 lang=scala
 *
 * [437] 路径总和 III
 */
package Q437

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}
// @lc code=start
object Solution {
  def pathSum(root: TreeNode, targetSum: Int): Int = {
    def dfs(root: TreeNode, m: Map[Long, Int], ps: Long): Int = {
      root match {
        case null => 0
        case _ => {
          val s = ps + root.value.toLong
          val nm = m.updatedWith(s)(_ match {
            case None    => Some(1)
            case Some(n) => Some(n + 1)
          })
          m.getOrElse(s - targetSum, 0) + dfs(root.left, nm, s) + dfs(root.right, nm, s)
        }
      }
    }
    dfs(root, Map(0.toLong -> 1), 0)
  }
}
// @lc code=end
