/*
 * @lc app=leetcode.cn id=106 lang=scala
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */
package Q106

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
  def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode =
    postorder.length match {
      case 0 => null
      case _ =>
        val left_tree_size = inorder.indexOf(postorder.last)
        TreeNode(
          postorder.last,
          buildTree(
            inorder.slice(0, left_tree_size),
            postorder.slice(0, left_tree_size)
          ),
          buildTree(
            inorder.slice(left_tree_size + 1, inorder.length),
            postorder.slice(left_tree_size, postorder.length - 1)
          )
        )
    }
}
// @lc code=end
