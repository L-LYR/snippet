/*
 * @lc app=leetcode.cn id=630 lang=scala
 *
 * [630] 课程表 III
 */
package Q630

// @lc code=start
object Solution {
  def scheduleCourse(courses: Array[Array[Int]]): Int = {
    val q = scala.collection.mutable.PriorityQueue.empty[Int]
    courses.sortInPlaceBy(_(1)).foldLeft(0) { case (d, Array(duration, lastDay)) =>
      q.enqueue(duration)
      if (d + duration > lastDay) d + duration - q.dequeue()
      else d + duration
    }
    q.size
  }
}
// @lc code=end
