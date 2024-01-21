/*
 * @lc app=leetcode.cn id=103 lang=scala
 *
 * [103] 二叉树的锯齿形层序遍历
 */
package Q103

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
  def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
    @annotation.tailrec
    def helper(
        layer: Seq[TreeNode],
        layerValues: List[List[Int]] = List.empty,
        zigzag: Boolean = true
    ): List[List[Int]] = {
      if (layer.isEmpty) {
        layerValues
      } else {
        val layerValue = layer.map(_.value).toList
        helper(
          layer.flatMap(node =>
            Seq(Option(node.left), Option(node.right)).flatten
          ),
          layerValues :+ (if (zigzag) layerValue else layerValue.reverse),
          !zigzag
        )
      }
    }
    helper(Option(root).toSeq)
  }
}
// @lc code=end
