/*
 * @lc app=leetcode.cn id=1 lang=scala
 *
 * [1] 两数之和
 */
package Q1

// @lc code=start
object Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    @annotation.tailrec
    def helper(i: Int, m: Map[Int, Int]): Array[Int] = {
      m.get(target - nums(i)) match {
        case Some(j) => Array(j, i)
        case None    => helper(i + 1, m ++ Map(nums(i) -> i))
      }
    }
    helper(0, Map.empty)
  }
}
// @lc code=end
