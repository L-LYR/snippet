/*
 * @lc app=leetcode.cn id=307 lang=scala
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
class NumArray(_nums: Array[Int]) {
  val nums = _nums
  val tree = Array.fill(nums.size + 1)(0)
  (1 to nums.size).foreach(i => {
    tree.update(i, tree(i) + nums(i - 1))
    val nxt = i + (i & -i)
    if (nxt < tree.size) {
      tree.update(nxt, tree(nxt) + tree(i))
    }
  })

  def update(index: Int, value: Int): Unit = {
    val delta = value - nums(index)
    nums.update(index, value)
    Iterator
      .iterate(index + 1)(i => i + (i & -i))
      .takeWhile(_ < tree.size)
      .foreach(i => tree.update(i, tree(i) + delta))
  }

  def prefixSum(index: Int): Int = {
    Iterator
      .iterate(index)(i => i - (i & -i))
      .takeWhile(_ > 0)
      .foldLeft(0) { case (acc, i) => acc + tree(i) }
  }

  def sumRange(left: Int, right: Int): Int = {
    prefixSum(right + 1) - prefixSum(left)
  }

}
// @lc code=end
