/*
 * @lc app=leetcode.cn id=230 lang=scala
 *
 * [230] 二叉搜索树中第K小的元素
 */
package Q230

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
  def kthSmallest(root: TreeNode, k: Int): Int = {
    // var idx = 0;
    // var ans = 0;
    // def helper(root: TreeNode): Unit = if (root != null) {
    //   helper(root.left)
    //   idx = idx + 1
    //   if (idx == k) ans = root.value
    //   helper(root.right)
    // }
    // helper(root)
    // ans

    def inorder(root: TreeNode, count: Int): (Int, Option[Int]) = {
      if (root == null) (count, None)
      else {
        inorder(root.left, count) match {
          case (_, Some(kth))      => (0, Some(kth))
          case (c, None) if c == 1 => (0, Some(root.value))
          case (c, None)           => inorder(root.right, c - 1)
        }
      }
    }

    inorder(root, k)._2.get
  }
}
// @lc code=end
