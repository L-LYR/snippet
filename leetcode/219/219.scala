/*
 * @lc app=leetcode.cn id=219 lang=scala
 *
 * [219] 存在重复元素 II
 */
package Q219

// @lc code=start
object Solution {
  import scala.collection.mutable.Map
  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
    @annotation.tailrec
    def helper(i: Int, m: Map[Int, Int]): Boolean =
      i < nums.length && {
        m.get(nums(i)) match {
          case None => {
            m.addOne(nums(i) -> i)
            helper(i + 1, m)
          }
          case Some(j) =>
            (i - j <= k) || {
              m(nums(i)) = i
              helper(i + 1, m)
            }
        }
      }
    helper(0, Map.empty)
  }
}
// @lc code=end
