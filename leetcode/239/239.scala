/*
 * @lc app=leetcode.cn id=239 lang=scala
 *
 * [239] 滑动窗口最大值
 */
package Q239

// @lc code=start
object Solution {
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    // nums.sliding(k).map(_.max).toArray

    @annotation.tailrec
    def loop(i: Int, queue: Vector[Int], answers: Vector[Int]): Vector[Int] =
      queue match {
        case _ if i + 1 > nums.length     => answers
        case Nil                          => loop(i + 1, queue :+ i, answers :+ nums(i))
        case xs :+ x if nums(i) > nums(x) => loop(i, xs, answers)
        case x +: xs if x == i - k        => loop(i, xs, answers)
        case _                            => loop(i + 1, queue :+ i, answers :+ nums(queue.head))
      }

    loop(0, Vector.empty[Int], Vector.empty[Int]).drop(k - 1).toArray
  }
}
// @lc code=end
