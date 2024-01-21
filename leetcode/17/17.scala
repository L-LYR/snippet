/*
 * @lc app=leetcode.cn id=17 lang=scala
 *
 * [17] 电话号码的字母组合
 */
package Q17

// @lc code=start
object Solution {
  val trans = Map[Char, String](
    '2' -> "abc",
    '3' -> "def",
    '4' -> "ghi",
    '5' -> "jkl",
    '6' -> "mno",
    '7' -> "pqrs",
    '8' -> "tuv",
    '9' -> "wxyz"
  )
  def letterCombinations(digits: String): List[String] = {
    def dfs(i: Int, cur: String): List[String] = {
      if (i == digits.size) {
        if (cur.size != 0) { List(cur) }
        else { List.empty }
      } else {
        trans
          .getOrElse(digits(i), "")
          .foldLeft(List.empty[String])({ case (acc, c) =>
            acc ::: dfs(i + 1, cur :+ c)
          })
      }
    }
    dfs(0, "")
  }
}
// @lc code=end
