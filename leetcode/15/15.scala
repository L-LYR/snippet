/*
 * @lc app=leetcode.cn id=15 lang=scala
 *
 * [15] 三数之和
 */
package Q15

// @lc code=start
object Solution {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val counter = nums.foldLeft(Map.empty[Int, Int].withDefaultValue(0)) {
      (count, x) => count + (x -> (count(x) + 1))
    }

    val ns = counter.keys.toList.sorted

    for {
      a <- ns
      b <- ns
      if a <= b
      if a != b || counter(a) > 1
      c = -(a + b)
      if b <= c
      ok = List(a, b, c)
      if counter(c) >= ok.count(_ == c)
    } yield ok
  }
}
// @lc code=end
