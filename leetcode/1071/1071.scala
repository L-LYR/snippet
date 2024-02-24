/*
 * @lc app=leetcode.cn id=1071 lang=scala
 *
 * [1071] 字符串的最大公因子
 */
package Q1071

// @lc code=start
object Solution {
  def gcdOfStrings(str1: String, str2: String): String = {
    def gcd(a: Int, b: Int): Int = {
      if (b == 0) {
        a
      } else {
        gcd(b, a % b)
      }
    }
    if (str1 + str2 != str2 + str1) {
      ""
    } else {
      str1.slice(0, gcd(str1.length(), str2.length()))
    }

  }
}
// @lc code=end
