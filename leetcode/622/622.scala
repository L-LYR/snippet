/*
 * @lc app=leetcode.cn id=622 lang=scala
 *
 * [622] 设计循环队列
 */
package Q622

// @lc code=start
class MyCircularQueue(_k: Int) {
  val q = Array.ofDim[Int](_k + 1)
  var h = 0
  var t = 0

  def enQueue(value: Int): Boolean = {
    if (isFull()) { false }
    else {
      q(t) = value
      t = (t + 1) % q.size
      true
    }
  }

  def deQueue(): Boolean = {
    if (isEmpty()) { false }
    else {
      h = (h + 1) % q.size
      true
    }
  }

  def Front(): Int = {
    if (isEmpty()) { -1 }
    else { q(h) }
  }

  def Rear(): Int = {
    if (isEmpty()) { -1 }
    else { q((t - 1 + q.size) % q.size) }
  }

  def isEmpty(): Boolean = {
    h == t
  }

  def isFull(): Boolean = {
    (t + 1) % q.size == h
  }

}
// @lc code=end
