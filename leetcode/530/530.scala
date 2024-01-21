/*
 * @lc app=leetcode.cn id=530 lang=scala
 *
 * [530] 二叉搜索树的最小绝对差
 */
package Q530

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
  def getMinimumDifference(root: TreeNode): Int = {
    def inorderExpand(root: TreeNode): List[Int] = {
      root match {
        case null => List.empty
        case _ =>
          inorderExpand(root.left) ::: List(root.value) ::: inorderExpand(
            root.right
          )
      }
    }

    inorderExpand(root).sliding(2).map(s => s(1) - s(0)).min
  }
}
// @lc code=end
