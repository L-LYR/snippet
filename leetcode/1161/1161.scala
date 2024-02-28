/*
 * @lc app=leetcode.cn id=1161 lang=scala
 *
 * [1161] 最大层内元素和
 */
package Q1161
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}
// @lc code=start
object Solution {
  def maxLevelSum(root: TreeNode): Int = {
    @annotation.tailrec
    def helper(
        layer: Seq[TreeNode],
        layerSum: List[Int] = List.empty
    ): List[Int] = {
      if (layer.isEmpty) {
        layerSum
      } else {
        helper(
          layer.flatMap(node => Seq(Option(node.left), Option(node.right)).flatten),
          layerSum :+ layer.map(_.value).sum
        )
      }
    }
    helper(Option(root).toSeq).zipWithIndex.maxBy(_._1)._2 + 1
  }
}
// @lc code=end
