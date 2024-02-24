/*
 * @lc app=leetcode.cn id=2476 lang=scala
 *
 * [2476] 二叉搜索树最近节点查询
 */
package Q2476

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}
// @lc code=start
object Solution {
  import scala.collection.mutable.ListBuffer
  import scala.collection.Searching
  def closestNodes(root: TreeNode, queries: List[Int]): List[List[Int]] = {
    val nums = ListBuffer.empty[Int]
    def inorder(root: TreeNode): Unit = {
      Option(root) match {
        case None => {}
        case Some(n) => {
          inorder(n.left)
          nums.append(n.value)
          inorder(n.right)
        }
      }
    }
    inorder(root)
    val vnums = nums.toVector
    queries.map(x => {
      vnums.search(x) match {
        case Searching.InsertionPoint(i) =>
          i match {
            case i if i == vnums.size => List(vnums.last, -1)
            case i if i == 0          => List(-1, vnums.head)
            case i                    => List(vnums(i - 1), vnums(i))
          }
        case Searching.Found(_) => List(x, x)
      }
    })
  }
}
// @lc code=end
