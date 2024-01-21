/*
 * @lc app=leetcode.cn id=295 lang=scala
 *
 * [295] 数据流的中位数
 */
package Q295

// @lc code=start
class MedianFinder() {
  import scala.collection.mutable.PriorityQueue

  val l = new PriorityQueue[Int]()
  val r = new PriorityQueue[Int]()(Ordering[Int].reverse)

  def addNum(num: Int) {
    if (l.size == r.size) {
      if (r.size == 0 || num <= r.head) {
        l.enqueue(num)
      } else {
        l.enqueue(r.dequeue())
        r.enqueue(num)
      }
    } else {
      if (num >= l.head) {
        r.enqueue(num)
      } else {
        r.enqueue(l.dequeue())
        l.enqueue(num)
      }
    }
  }

  def findMedian(): Double = {
    if (l.size == r.size) {
      (l.head + r.head).toDouble / 2.0
    } else {
      l.head.toDouble
    }
  }

}
// @lc code=end
