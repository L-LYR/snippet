/*
 * @lc app=leetcode.cn id=1318 lang=scala
 *
 * [1318] 或运算的最小翻转次数
 */
package Q1318

// @lc code=start
object Solution {
  def minFlips(a: Int, b: Int, c: Int): Int = {
    Integer.bitCount(c) - Integer.bitCount(c & (a | b)) +
      Integer.bitCount(~c & a) + Integer.bitCount(~c & b)
  }
}
// @lc code=end
