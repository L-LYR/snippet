/*
 * @lc app=leetcode.cn id=2670 lang=scala
 *
 * [2670] 找出不同元素数目差数组
 */
package Q2670

// @lc code=start
object Solution {
  def distinctDifferenceArray(nums: Array[Int]): Array[Int] = {
    nums
      .scanLeft(
        (0, Map.empty[Int, Int], nums.groupMapReduce(identity)(_ => 1)(_ + _))
      ) {
        case ((acc, l, r), x) => {
          val nl = l.updatedWith(x)(_.orElse(Some(0)).map(_ + 1))
          val nr = r.updatedWith(x)(_ match {
            case Some(x) if x > 1 => Some(x - 1)
            case _                => None
          })
          (nl.size - nr.size, nl, nr)
        }
      }
      .drop(1)
      .map(_._1)
  }
}
// @lc code=end
