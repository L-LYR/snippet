/*
 * @lc app=leetcode.cn id=108 lang=scala
 *
 * [108] 将有序数组转换为二叉搜索树
 */
package Q108

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
  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    if (nums.length == 0) null
    else {
      val m = nums.length / 2
      TreeNode(
        nums(m),
        sortedArrayToBST(nums.slice(0, m)),
        sortedArrayToBST(nums.slice(m + 1, nums.length))
      )
    }
  }
}
// @lc code=end
