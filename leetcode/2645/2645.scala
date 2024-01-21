/*
 * @lc app=leetcode.cn id=2645 lang=scala
 *
 * [2645] 构造有效字符串的最少插入数
 */
package Q2645

// @lc code=start
object Solution {
  def addMinimum(word: String): Int = {
    word
      .foldLeft(Some(('c', 0)))({ case (Some((prev, count)), cur) =>
        (prev, cur) match {
          case ('a', 'a') | ('b', 'b') | ('c', 'c') => Some((cur, count + 2))
          case ('b', 'a') | ('c', 'b') | ('a', 'c') => Some((cur, count + 1))
          case ('a', 'b') | ('b', 'c') | ('c', 'a') => Some((cur, count))
        }
      })
      .map(p =>
        p._1 match {
          case 'a' => p._2 + 2
          case 'b' => p._2 + 1
          case 'c' => p._2
        }
      )
      .get
  }
}
// @lc code=end
