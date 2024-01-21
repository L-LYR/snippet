/*
 * @lc app=leetcode.cn id=88 lang=scala
 *
 * [88] 合并两个有序数组
 */
package Q88

// @lc code=start
object Solution {
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    @annotation.tailrec
    def helper(i: Int, j: Int, k: Int): Unit = {
      if (j >= 0) {
        if (i >= 0 && nums1(i) > nums2(j)) {
          nums1.update(k, nums1(i))
          helper(i - 1, j, k - 1)
        } else {
          nums1.update(k, nums2(j))
          helper(i, j - 1, k - 1)
        }
      }
    }

    helper(m - 1, n - 1, m + n - 1)
  }
}
// @lc code=end
