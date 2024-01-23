/*
 * @lc app=leetcode.cn id=907 lang=scala
 *
 * [907] 子数组的最小值之和
 */
package Q907

// @lc code=start
object Solution {
  import scala.collection.mutable.Stack
  def sumSubarrayMins(arr: Array[Int]): Int = {
    val s = Stack.empty[Int]
    val f = Array.fill(arr.size)(0)
    arr.indices.foreach(i => {
      s.popWhile(j => arr(i) <= arr(j))
      s.headOption match {
        case None    => f(i) = arr(i) * (i + 1)
        case Some(k) => f(i) = f(k) + arr(i) * (i - k)
      }
      s.push(i)
    })
    f.foldLeft(0) { case (acc, x) => (acc + x) % 1_000_000_007 }
  }
}
// @lc code=end
