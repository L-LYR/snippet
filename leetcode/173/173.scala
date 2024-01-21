/*
 * @lc app=leetcode.cn id=173 lang=scala
 *
 * [173] 二叉搜索树迭代器
 */

package Q173

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

// @lc code=start
class BSTIterator(_root: TreeNode) {
  def InorderIter: TreeNode => Iterator[Int] = {
    case null => Iterator.empty
    case node =>
      InorderIter(node.left) ++
        Iterator.single(node.value) ++
        InorderIter(node.right)
  }
  val iter = InorderIter(_root)
  def next(): Int = iter.next
  def hasNext(): Boolean = iter.hasNext
}
// @lc code=end
