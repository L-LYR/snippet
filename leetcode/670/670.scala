/*
 * @lc app=leetcode.cn id=670 lang=scala
 *
 * [670] 最大交换
 */
package Q670

// @lc code=start
object Solution {
  def maximumSwap(num: Int): Int = {
    val s = num.toString
    s.zipWithIndex
      .filter(_._1 < '9')
      .map { case (_, i) =>
        (s.length - 1 until i by -1).foldLeft((-1, s(i))) {
          case ((_, mx), j) if s(j) > mx => (j, s(j))
          case (acc, _)                  => acc
        } match {
          case (-1, _) => None
          case (j, _)  => Some((i, j))
        }
      }
      .dropWhile(_.isEmpty)
      .headOption
      .flatten match {
      case None         => num
      case Some((i, j)) => s.updated(j, s(i)).updated(i, s(j)).toInt
    }
  }
}
// @lc code=end
