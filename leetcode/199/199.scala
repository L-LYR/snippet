/*
 * @lc app=leetcode.cn id=199 lang=scala
 *
 * [199] 二叉树的右视图
 */
package Q199

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
  def rightSideView(root: TreeNode): List[Int] = {

    @annotation.tailrec
    def helper(
        layer: Seq[TreeNode],
        view: List[Int] = List.empty
    ): List[Int] = {
      if (layer.isEmpty) {
        view
      } else {
        helper(
          layer.flatMap(node =>
            Seq(Option(node.left), Option(node.right)).flatten
          ),
          view :+ layer.last.value
        )
      }
    }

    helper(Option(root).toSeq)
  }
}
// @lc code=end
