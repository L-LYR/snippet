/*
 * @lc app=leetcode.cn id=2575 lang=scala
 *
 * [2575] 找出字符串的可整除数组
 */
package Q2575

// @lc code=start
object Solution {
  def divisibilityArray(word: String, m: Int): Array[Int] = {
    word
      .map(c => c - '0')
      .scanLeft(0.toLong) { case (x, c) => (x * 10 + c) % m }
      .drop(1)
      .map(i => if (i == 0) 1 else 0)
      .toArray
  }
}
// @lc code=end
