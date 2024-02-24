/*
 * @lc app=leetcode.cn id=933 lang=scala
 *
 * [933] 最近的请求次数
 */
package Q933

// @lc code=start
class RecentCounter() {
  import scala.collection.mutable.Queue
  val q = Queue.empty[Int]

  def ping(t: Int): Int = {
    q.dequeueWhile(_ < t - 3000)
    q.enqueue(t).size
  }
}
// @lc code=end
