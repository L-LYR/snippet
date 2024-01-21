/*
 * @lc app=leetcode.cn id=139 lang=scala
 *
 * [139] 单词拆分
 */
package Q139

// @lc code=start
object Solution {
  def wordBreak(s: String, wordDict: List[String]): Boolean = {
    val dp = Array.fill(s.size + 1)(false)
    dp(0) = true
    for (i <- 1 to s.size) {
      for (j <- i - 1 to 0 by -1) {
        dp(i) = dp(i) || dp(j) && wordDict.contains(s.slice(j, i))
      }
    }
    dp.last
  }
}
// @lc code=end
