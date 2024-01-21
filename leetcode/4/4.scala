/*
 * @lc app=leetcode.cn id=4 lang=scala
 *
 * [4] 寻找两个正序数组的中位数
 */
package Q4

// @lc code=start
object Solution {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    def binarySearchKth(k: Int): Int = {
      @annotation.tailrec
      def helper(l: Int, r: Int): Int = {
        if (l < r) {
          val m = (r - l) / 2 + l
          if (nums2(k - m - 1) > nums1(m)) helper(m + 1, r)
          else helper(l, m)
        } else if (l == 0) {
          nums2(k - 1)
        } else if (l == k) {
          nums1(l - 1)
        } else {
          math.max(nums1(l - 1), nums2(k - l - 1))
        }
      }
      val l = math.max(0, k - nums2.size)
      val r = math.min(k, nums1.size)
      helper(l, r)
    }

    val n = nums1.size + nums2.size
    if (n % 2 == 1) {
      binarySearchKth(n / 2 + 1).toDouble
    } else {
      (binarySearchKth(n / 2).toDouble +
        binarySearchKth(n / 2 + 1).toDouble) / 2
    }
  }
}
// @lc code=end
