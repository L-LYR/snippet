/*
 * @lc app=leetcode.cn id=84 lang=scala
 *
 * [84] 柱状图中最大的矩形
 */
package Q84

// @lc code=start
object Solution {
  import scala.collection.mutable.Stack
  def largestRectangleArea(heights: Array[Int]): Int = {
    val l = Array.fill(heights.size)(-1)
    val r = Array.fill(heights.size)(heights.size)
    val s = Stack.empty[Int]
    heights.indices.foreach(i => {
      s.popWhile(j => heights(j) > heights(i)).foreach(r.update(_, i))
      s.push(i)
    })
    s.clear
    heights.indices.reverse.foreach(i => {
      s.popWhile(j => heights(j) > heights(i)).foreach(l.update(_, i))
      s.push(i)
    })
    heights.lazyZip(l).lazyZip(r).map { case (h, l, r) => h * (r - l - 1) }.max
  }
}
// @lc code=end
