/*
 * @lc app=leetcode.cn id=889 lang=scala
 *
 * [889] 根据前序和后序遍历构造二叉树
 */
package Q889
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}
// @lc code=start
object Solution {
  def constructFromPrePost(preorder: Array[Int], postorder: Array[Int]): TreeNode = {
    def helper(prel: Int, prer: Int, postl: Int, postr: Int): TreeNode = {
      if (prel >= prer) { null }
      else if (prel + 1 == prer) {
        new TreeNode(preorder(prel))
      } else {
        val leftTreeSize = postorder.indexOf(preorder(prel + 1), postl) - postl + 1
        new TreeNode(
          preorder(prel),
          helper(prel + 1, prel + 1 + leftTreeSize, postl, postl + leftTreeSize),
          helper(prel + 1 + leftTreeSize, prer, postl + leftTreeSize, postr)
        )
      }
    }
    helper(0, preorder.size, 0, postorder.size)
  }
}
// @lc code=end
