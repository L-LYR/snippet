/*
 * @lc app=leetcode.cn id=105 lang=scala
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */
package Q105

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
import scala.collection.IndexedSeqView

object Solution {
  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode =
    preorder.length match {
      case 0 => null
      case _ =>
        val left_tree_size = inorder.indexOf(preorder.head)
        TreeNode(
          preorder.head,
          buildTree(
            preorder.slice(1, 1 + left_tree_size),
            inorder.slice(0, left_tree_size)
          ),
          buildTree(
            preorder.slice(1 + left_tree_size, preorder.length),
            inorder.slice(1 + left_tree_size, inorder.length)
          )
        )
    }
}
// @lc code=end
