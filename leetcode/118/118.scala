/*
 * @lc app=leetcode.cn id=118 lang=scala
 *
 * [118] 杨辉三角
 */
package Q118

// @lc code=start
object Solution {
  def generate(numRows: Int): List[List[Int]] = {
    LazyList
      .iterate(List(1)) { prevRow ⇒
        1 +: (if (prevRow.length == 1) List.empty else prevRow.sliding(2).map(_.sum).toList) :+ 1
      }
      .take(numRows)
      .toList
  }
}
// @lc code=end
