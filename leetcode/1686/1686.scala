/*
 * @lc app=leetcode.cn id=1686 lang=scala
 *
 * [1686] 石子游戏 VI
 */
package Q1686

// @lc code=start
object Solution {
  def stoneGameVI(aliceValues: Array[Int], bobValues: Array[Int]): Int = {
    aliceValues.indices.toArray
      .sortInPlaceBy(i => -(aliceValues(i) + bobValues(i)))
      .zipWithIndex
      .foldLeft(0) {
        case (acc, (i, idx)) if idx % 2 == 0 => acc + aliceValues(i)
        case (acc, (i, _))                   => acc - bobValues(i)
      } match {
      case x if x > 0  => 1
      case x if x == 0 => 0
      case x if x < 0  => -1
    }
  }
}
// @lc code=end
