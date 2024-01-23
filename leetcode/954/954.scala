/*
 * @lc app=leetcode.cn id=954 lang=scala
 *
 * [954] 二倍数对数组
 */
package Q954

// @lc code=start
object Solution {
  def canReorderDoubled(arr: Array[Int]): Boolean = {
    val m = arr.groupMapReduce(identity)(_ => 1)(_ + _)
    arr.sorted
      .foldLeft((true, m)) {
        case ((ok, m), x) if m.get(x).get == 0 => (ok, m)
        case ((ok, m), x) if m.get(x * 2).exists(_ > 0) =>
          (ok, m.updatedWith(x)(_.map(_ - 1)).updatedWith(2 * x)(_.map(_ - 1)))
        case ((ok, m), x) if x % 2 == 0 && m.get(x / 2).exists(_ > 0) =>
          (ok, m.updatedWith(x)(_.map(_ - 1)).updatedWith(x / 2)(_.map(_ - 1)))
        case ((_, m), _) => (false, m)
      }
      ._1
  }
}
// @lc code=end
