/*
 * @lc app=leetcode.cn id=102 lang=scala
 *
 * [102] 二叉树的层序遍历
 */
package Q102

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
  def levelOrder(root: TreeNode): List[List[Int]] = {
    @annotation.tailrec
    def helper(
        layer: Seq[TreeNode],
        layerValues: List[List[Int]] = List.empty
    ): List[List[Int]] = {
      if (layer.isEmpty) {
        layerValues
      } else {
        helper(
          layer.flatMap(node =>
            Seq(Option(node.left), Option(node.right)).flatten
          ),
          layerValues :+ layer.map(_.value).toList
        )
      }
    }
    helper(Option(root).toSeq)
  }
}
// @lc code=end
