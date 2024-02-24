/*
 * @lc app=leetcode.cn id=107 lang=scala
 *
 * [107] 二叉树的层序遍历 II
 */
package Q107

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

// @lc code=start
object Solution {
  def levelOrderBottom(root: TreeNode): List[List[Int]] = {
    @annotation.tailrec
    def helper(
        layer: Seq[TreeNode],
        layerValues: List[List[Int]] = List.empty
    ): List[List[Int]] = {
      if (layer.isEmpty) {
        layerValues
      } else {
        helper(
          layer.flatMap(node => Seq(Option(node.left), Option(node.right)).flatten),
          layerValues :+ layer.map(_.value).toList
        )
      }
    }
    helper(Option(root).toSeq).reverse
  }
}
// @lc code=end
