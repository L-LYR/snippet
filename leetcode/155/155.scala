/*
 * @lc app=leetcode.cn id=155 lang=scala
 *
 * [155] 最小栈
 */
package Q155

// @lc code=start
class MinStack() {
  import scala.collection.mutable.Stack

  val s = Stack.empty[Int]
  val min_s = Stack.empty[Int]

  def push(v: Int) {
    s.push(v)
    min_s.push(v.min(min_s.headOption.getOrElse(Int.MaxValue)))
  }

  def pop() {
    s.pop()
    min_s.pop()
  }

  def top(): Int = {
    s.top
  }

  def getMin(): Int = {
    min_s.top
  }

}
// @lc code=end
