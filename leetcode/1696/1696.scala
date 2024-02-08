/*
 * @lc app=leetcode.cn id=1696 lang=scala
 *
 * [1696] 跳跃游戏 VI
 */
package Q1696

// @lc code=start
object Solution {
  def maxResult(nums: Array[Int], k: Int): Int = {
    val n = nums.size
    val f = Array.fill(n)(Int.MinValue)
    f(0) = nums(0)
    // @annotation.tailrec
    // def dfs(q: List[Int], i: Int, updated: Boolean): Int = {
    //   if (i == n) {
    //     f(n - 1)
    //   } else if (!q.isEmpty && q.head < i - k) {
    //     dfs(q.tail, i, false)
    //   } else if (!updated) {
    //     f(i) = nums(i) + f(q.head)
    //     dfs(q, i, true)
    //   } else if (!q.isEmpty && f(i) >= f(q.last)) {
    //     dfs(q.init, i, true)
    //   } else {
    //     dfs(q :+ i, i + 1, false)
    //   }
    // }
    // dfs(List(0), 1, false)
    @annotation.tailrec
    def loop(i: Int, q: List[Int]): Int = {
      q match {
        case Nil                  => loop(i + 1, q :+ i)
        case _ if i == n          => f(n - 1)
        case x +: xs if x < i - k => loop(i, xs)
        case _ if f(i) == Int.MinValue => {
          f(i) = nums(i) + f(q.head)
          loop(i, q)
        }
        case xs :+ x if f(i) >= f(x) => loop(i, xs)
        case _                       => loop(i + 1, q :+ i)
      }
    }
    loop(0, List.empty)
  }
}
// @lc code=end
