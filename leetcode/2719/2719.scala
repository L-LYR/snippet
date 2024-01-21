/*
 * @lc app=leetcode.cn id=2719 lang=scala
 *
 * [2719] 统计整数数目
 */
package Q2719

// @lc code=start
object Solution {
//   import scala.collection.mutable.HashMap

//   def memorize[I, O](f: I => O): I => O = new HashMap[I, O]() {
//     override def apply(key: I) = getOrElseUpdate(key, f(key))
//   }

//   def count(num1: String, num2: String, min_sum: Int, max_sum: Int): Int = {
//     lazy val dfs: ((Int, Int, Boolean, Boolean)) => Int = memorize { case (i, s, lb, ub) =>
//       if (s > max_sum) {
//         0
//       } else if (i == num2.size) {
//         if (s >= min_sum) 1 else 0
//       } else {
//         val lo = if (lb) num1(i) else '0'
//         val hi = if (ub) num2(i) else '9'
//         (lo to hi).foldLeft(0)((acc, c) => {
//           (acc + dfs(i + 1, c.asDigit + s, lb && c == lo, ub && c == hi)) % 1000000007
//         })
//       }
//     }

//     if (num1.length < num2.length) {
//       val newNum1 = num1.prependedAll("0" * (num2.length - num1.length))
//       count(newNum1, num2, min_sum, max_sum)
//     } else {
//       dfs(0, 0, true, true)
//     }
//   }

  def count(num1: String, num2: String, min_sum: Int, max_sum: Int): Int = {
    val memo = new HashMap[(Int, Int), Int]()
    def dfs(i: Int, s: Int, lb: Boolean, ub: Boolean): Int =
      if (s > max_sum) {
        0
      } else if (i == num2.size) {
        if (s >= min_sum) 1 else 0
      } else if (!lb && !ub && memo.contains((i, s))) {
        memo.get((i, s)).get
      } else {
        val lo = if (lb) num1(i) else '0'
        val hi = if (ub) num2(i) else '9'
        val res = (lo to hi).foldLeft(0)((acc, c) => {
          (acc + dfs(i + 1, c.asDigit + s, lb && c == lo, ub && c == hi)) % 1000000007
        })
        if (!lb && !ub) {
          memo.addOne((i, s), res)
        }
        res
      }

    if (num1.length < num2.length) {
      val newNum1 = num1.prependedAll("0" * (num2.length - num1.length))
      count(newNum1, num2, min_sum, max_sum)
    } else {
      dfs(0, 0, true, true)
    }
  }
}
// @lc code=end
