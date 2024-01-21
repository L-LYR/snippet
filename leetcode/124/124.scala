/*
 * @lc app=leetcode.cn id=124 lang=scala
 *
 * [124] 二叉树中的最大路径和
 */
package Q124

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

// @lc code=start
object Solution {
  def maxPathSum(root: TreeNode): Int = {
    def dfs(root: TreeNode, cur: Int): (Int, Int) = {
      root match {
        case null => (Int.MinValue, 0)
        case _ => {
          val l = dfs(root.left, cur)
          val r = dfs(root.right, cur)
          (
            math.max(math.max(l._1, r._1), l._2 + r._2 + root.value), // this subtree's max path sum
            math.max(0, math.max(l._2, r._2) + root.value) // this subtree's max 
          )
        }
      }
    }
    dfs(root, Int.MinValue)._1
  }
}
// @lc code=end
