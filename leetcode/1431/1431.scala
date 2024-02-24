/*
 * @lc app=leetcode.cn id=1431 lang=scala
 *
 * [1431] 拥有最多糖果的孩子
 */
package Q1431

// @lc code=start
object Solution {
  def kidsWithCandies(candies: Array[Int], extraCandies: Int): List[Boolean] = {
    val mx = candies.max
    candies.iterator.map(_ + extraCandies >= mx).toList
  }
}
// @lc code=end
