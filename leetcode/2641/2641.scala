/*
 * @lc app=leetcode.cn id=2641 lang=scala
 *
 * [2641] 二叉树的堂兄弟节点 II
 */
package Q2641

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

// MLE 32/41
// @lc code=start
object Solution {
  def replaceValueInTree(root: TreeNode): TreeNode = {
    import scala.collection.mutable.ListBuffer
    @annotation.tailrec
    def bfs(layer: ListBuffer[TreeNode]): Unit = {
      val (layerSum, nextLayer) = layer.foldLeft((0, ListBuffer.empty[TreeNode])) {
        case ((s, next_layer), node) => {
          val children = Seq(node.left, node.right).filter(_ != null)
          (s + children.map(_.value).sum, next_layer.appendAll(children))
        }
      }
      layer.foreach(node => {
        val broSum =
          Option(node.left).map(_.value).getOrElse(0) +
            Option(node.right).map(_.value).getOrElse(0)
        val cousinSum = layerSum - broSum
        Option(node.left).foreach(_.value = cousinSum)
        Option(node.right).foreach(_.value = cousinSum)
      })
      if (!nextLayer.isEmpty) {
        bfs(nextLayer)
      }
    }
    root.value = 0
    bfs(ListBuffer(root))
    root
  }
}
// @lc code=end
