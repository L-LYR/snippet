/*
 * @lc app=leetcode.cn id=130 lang=scala
 *
 * [130] 被围绕的区域
 */
package Q130

// @lc code=start
object Solution {
  def solve(board: Array[Array[Char]]): Unit = {
    def dfs(i: Int, j: Int) {
      if (i >= 0 && j >= 0 && i < board.size && j < board(0).size && board(i)(j) == 'O') {
        board(i)(j) = '-'
        dfs(i + 1, j)
        dfs(i, j + 1)
        dfs(i - 1, j)
        dfs(i, j - 1)
      }
    }

    for (i <- 0 until board.size) {
      dfs(i, 0)
      dfs(i, board(0).size - 1)
    }
    for (j <- 0 until board(0).size) {
      dfs(0, j)
      dfs(board.size - 1, j)
    }

    for {
      i <- 0 until board.size
      j <- 0 until board(0).size
    } {
      if (board(i)(j) == '-') {
        board(i)(j) = 'O'
      } else if (board(i)(j) == 'O') {
        board(i)(j) = 'X'
      }
    }
  }
}
// @lc code=end
