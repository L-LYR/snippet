/*
 * @lc app=leetcode.cn id=2215 lang=scala
 *
 * [2215] 找出两数组的不同
 */
package Q2215

// @lc code=start
object Solution {
  def findDifference(nums1: Array[Int], nums2: Array[Int]): List[List[Int]] = {
    val s1 = nums1.toSet
    val s2 = nums2.toSet
    List(s1.diff(s2).toList, s2.diff(s1).toList)
  }
}
// @lc code=end
