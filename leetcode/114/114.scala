/*
 * @lc app=leetcode.cn id=114 lang=scala
 *
 * [114] 二叉树展开为链表
 */

package Q114

class TreeNode(
    _value: Int = 0,
    _left: TreeNode = null,
    _right: TreeNode = null
) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

// @lc code=start
object Solution {
  def flatten(root: TreeNode): Unit = {
    // def helper(root: TreeNode): TreeNode = {
    //   if (root == null) {
    //     null
    //   } else if (root.left == null && root.right == null) {
    //     root
    //   } else if (root.left == null) {
    //     helper(root.right)
    //   } else if (root.right == null) {
    //     root.right = root.left
    //     root.left = null
    //     helper(root.right)
    //   } else {
    //     val right_last = helper(root.right)
    //     val left_last = helper(root.left)
    //     left_last.right = root.right
    //     root.right = root.left
    //     root.left = null
    //     right_last
    //   }
    // }
    // helper(root)

    def helper(curr: TreeNode, fa: TreeNode): TreeNode = {
      if (curr == null) {
        fa
      } else {
        fa.left = null
        fa.right = curr
        helper(curr.right, helper(curr.left, curr))
      }
    }
    helper(root, TreeNode(0))
  }
}
// @lc code=end
