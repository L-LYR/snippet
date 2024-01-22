/*
 * @lc app=leetcode.cn id=739 lang=scala
 *
 * [739] 每日温度
 */
package Q739

// @lc code=start
object Solution {
  import scala.collection.mutable.Stack
  def dailyTemperatures(temperatures: Array[Int]): Array[Int] = {
    val ans = Array.fill(temperatures.size)(0)
    val s = Stack.empty[Int]
    @annotation.tailrec
    def update(i: Int): Unit = {
      if (s.size > 0 && temperatures(s.top) < temperatures(i)) {
        ans.update(s.top, i - s.pop)
        update(i)
      }
    }
    temperatures.indices.foreach(i => { update(i); s.push(i) })
    ans
  }
}
// @lc code=end
