/*
 * @lc app=leetcode.cn id=22 lang=scala
 *
 * [22] 括号生成
 */
package Q22

// @lc code=start
object Solution {
  def generateParenthesis(n: Int): List[String] = {
    def dfs(l: Int, r: Int, cur: String): List[String] = {
      if (l == n && r == n) {
        List(cur)
      } else {
        if (l <= n && r < n && r < l) {
          dfs(l + 1, r, cur :+ '(') ::: dfs(l, r + 1, cur :+ ')')
        } else if (l < n) {
          dfs(l + 1, r, cur :+ '(')
        } else {
          List.empty
        }
      }
    }
    dfs(0, 0, "")
  }
}
// @lc code=end
