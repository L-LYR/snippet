/*
 * @lc app=leetcode.cn id=2583 lang=scala
 *
 * [2583] 二叉树中的第 K 大层和
 */
package Q2583
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}
// @lc code=start
object Solution {
  def kthLargestLevelSum(root: TreeNode, k: Int): Long = {
    import scala.collection.mutable.{Queue, PriorityQueue}
    @annotation.tailrec
    def helper(
        layer: Queue[TreeNode]
    )(implicit kq: PriorityQueue[Long] = new PriorityQueue()(Ordering[Long].reverse)): Long = {
      if (layer.isEmpty) {
        if (kq.size < k) -1 else kq.head
      } else {
        val curSum = layer.iterator.map(_.value.toLong).sum
        val nextLayer = layer.flatMap(n => Seq(Option(n.left), Option(n.right)).flatten)
        kq.addOne(curSum)
        if (kq.size > k) {
          kq.dequeue()
        }
        helper(nextLayer)(kq)
      }
    }
    helper(Queue(root))
  }
}
// @lc code=end
