/*
 * @lc app=leetcode.cn id=735 lang=scala
 *
 * [735] 小行星碰撞
 */
package Q735

// @lc code=start
object Solution {
  def asteroidCollision(asteroids: Array[Int]): Array[Int] = {
    @annotation.tailrec
    def helper(l: List[Int], i: Int): Array[Int] = {
      if (i == asteroids.size) {
        l.toArray
      } else {
        val a = asteroids(i)
        if (l.isEmpty || a > 0 || l.last < 0) {
          helper(l :+ a, i + 1)
        } else {
          if (!l.isEmpty && l.last > 0) {
            if (l.last < -a) {
              helper(l.init, i)
            } else if (l.last == -a) {
              helper(l.init, i + 1)
            } else {
              helper(l, i + 1)
            }
          } else {
            helper(l :+ a, i + 1)
          }
        }
      }
    }
    helper(List.empty, 0)
  }
}
// @lc code=end
