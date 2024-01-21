/*
 * @lc app=leetcode.cn id=79 lang=scala
 *
 * [79] 单词搜索
 */
package Q79

// @lc code=start
object Solution {
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    val m = board.size
    val n = board(0).size
    def dfs(i: Int, j: Int, k: Int): Boolean = {
      if (i < 0 || j < 0 || i >= m || j >= n) {
        false
      } else if (board(i)(j) != word(k)) {
        false
      } else if (k + 1 == word.size) {
        true
      } else {
        val c = board(i)(j)
        board(i).update(j, '#')
        val ok = dfs(i + 1, j, k + 1) ||
          dfs(i, j + 1, k + 1) ||
          dfs(i - 1, j, k + 1) ||
          dfs(i, j - 1, k + 1)
        board(i).update(j, c)
        ok
      }
    }
    (for (i <- 0 until m; j <- 0 until n)
      yield { dfs(i, j, 0) }).exists(identity)
  }
}
// @lc code=end
