/*
 * @lc app=leetcode.cn id=78 lang=scala
 *
 * [78] 子集
 */
package Q78

// @lc code=start
object Solution {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    val l = nums.toList
    (0 to nums.size).foldLeft(List.empty[List[Int]]) { case (acc, i) =>
      acc ++ l.combinations(i).toList
    }
  }
}
// @lc code=end
