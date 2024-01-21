/*
 * @lc app=leetcode.cn id=52 lang=scala
 *
 * [52] N 皇后 II
 */
package Q52

// @lc code=start
object Solution {
  def totalNQueens(n: Int): Int = {
    def diagonalCheck(board: Seq[Int]) =
      board.zipWithIndex.map { case (col, row) => col - row }.distinct.length == n

    (0 until n).permutations.count(board => diagonalCheck(board) && diagonalCheck(board.reverse))
  }
}
// @lc code=end
