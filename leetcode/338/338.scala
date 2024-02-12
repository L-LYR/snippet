/*
 * @lc app=leetcode.cn id=338 lang=scala
 *
 * [338] 比特位计数
 */
package Q338

// @lc code=start
object Solution {
  def countBits(n: Int): Array[Int] = {
    (0 to n).map(Integer.bitCount(_)).toArray
  }
}
// @lc code=end
