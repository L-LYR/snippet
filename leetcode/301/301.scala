/*
 * @lc app=leetcode.cn id=301 lang=scala
 *
 * [301] 删除无效的括号
 */
package Q301

// @lc code=start
object Solution {
  def removeInvalidParentheses(s: String): List[String] = {
    @annotation.tailrec
    def getMinKToRemove(stk: List[Char], i: Int, k: Int): Int = {
      if (i == s.size) {
        k + stk.size
      } else if (s(i) == '(') {
        getMinKToRemove(stk :+ s(i), i + 1, k)
      } else if (s(i) == ')') {
        stk.lastOption match {
          case Some('(') => getMinKToRemove(stk.init, i + 1, k)
          case _         => getMinKToRemove(stk, i + 1, k + 1)
        }
      } else {
        getMinKToRemove(stk, i + 1, k)
      }
    }

    val k = getMinKToRemove(List.empty, 0, 0)

    def dfs(i: Int, ck: Int, l: Int, r: Int, cur: String): List[String] = {
      if (i == s.size) {
        if (ck == k && l == r) List(cur) else List.empty
      } else {
        dfs(i + 1, ck + 1, l, r, cur) ++
          (if (s(i) == '(' && l >= r) {
             dfs(i + 1, ck, l + 1, r, cur :+ s(i))
           } else if (s(i) == ')' && l > r) {
             dfs(i + 1, ck, l, r + 1, cur :+ s(i))
           } else if (s(i).isLetter) {
             dfs(i + 1, ck, l, r, cur :+ s(i))
           } else {
             List.empty
           })
      }
    }

    dfs(0, 0, 0, 0, "").distinct
  }
}
// @lc code=end
