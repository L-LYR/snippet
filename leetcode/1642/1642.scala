/*
 * @lc app=leetcode.cn id=1642 lang=scala
 *
 * [1642] 可以到达的最远建筑
 */

// @lc code=start
object Solution {
  def furthestBuilding(heights: Array[Int], bricks: Int, ladders: Int): Int = {
    val len = heights.length
    val pq = collection.mutable.PriorityQueue.empty[Int]

    @annotation.tailrec
    def step(i: Int, bricks: Int, ladders: Int): Int =
      if (i == len) { i - 1 }
      else {
        val diff = heights(i) - heights(i - 1)
        if (diff <= 0) {
          step(i + 1, bricks, ladders)
        } else if (diff <= bricks) {
          pq.enqueue(diff)
          step(i + 1, bricks - diff, ladders)
        } else if (ladders == 0) {
          i - 1
        } else if (pq.nonEmpty && diff < pq.head) {
          pq.enqueue(diff)
          step(i + 1, bricks + pq.dequeue - diff, ladders - 1)
        } else {
          step(i + 1, bricks, ladders - 1)
        }
      }

    step(1, bricks, ladders)
  }
}
// @lc code=end
