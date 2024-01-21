/*
 * @lc app=leetcode.cn id=337 lang=scala
 *
 * [337] 打家劫舍 III
 */
package Q337

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

// @lc code=start
object Solution {
  def rob(root: TreeNode): Int = {
    def dfs(root: TreeNode): (Int, Int) = {
      root match {
        case null => (0, 0)
        case _ => {
          val (lr, lnr) = dfs(root.left)
          val (rr, rnr) = dfs(root.right)
          (lnr + rnr + root.value, math.max(lr, lnr) + math.max(rr, rnr))
        }
      }
    }
    val (r, nr) = dfs(root)
    math.max(r, nr)
  }
}
// @lc code=end
