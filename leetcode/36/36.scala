/*
 * @lc app=leetcode.cn id=36 lang=scala
 *
 * [36] 有效的数独
 */
package Q36

// @lc code=start
object Solution {
  private val Empty = '.'

  implicit class SudokuBoard(board: Array[Array[Char]]) {
    def rows = board
    def columns = board.transpose

    def subBoxes =
      corners.map { case (x, y) => getSubBox(x, y).toArray }.toArray

    private def getSubBox(startX: Int, startY: Int) =
      for {
        y <- startY until startY + 3
        slice <- board(y).slice(startX, startX + 3)
      } yield slice

    private val corners = for {
      x <- 0 until 9 by 3
      y <- 0 until 9 by 3
    } yield (x, y)
  }

  def isValidSudoku(board: Array[Array[Char]]): Boolean =
    board.rows.forall(isValid) &&
      board.columns.forall(isValid) &&
      board.subBoxes.forall(isValid)

  private def isValid(seq: Array[Char]): Boolean = {
    val filled = seq.filter(_ != Empty)
    filled.distinct.length == filled.length
  }
}
// @lc code=end
