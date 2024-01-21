/*
 * @lc app=leetcode.cn id=637 lang=scala
 *
 * [637] 二叉树的层平均值
 */
package Q637

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
  def averageOfLevels(root: TreeNode): Array[Double] = {
    import scala.collection.mutable.ArrayBuffer

    val view = ArrayBuffer[Double]()

    @annotation.tailrec
    def helper(layer: Seq[TreeNode]): Unit = {
      if (!layer.isEmpty) {
        view.addOne(layer.map[Double](_.value).sum / layer.size.toDouble)
        helper(
          layer.flatMap(node =>
            Seq(Option(node.left), Option(node.right)).flatten
          )
        )
      }
    }

    helper(Option(root).toSeq)
    view.toArray
  }
}
// @lc code=end
