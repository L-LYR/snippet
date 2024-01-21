/*
 * @lc app=leetcode.cn id=191 lang=scala
 *
 * [191] 位1的个数
 */
package Q191

// @lc code=start
object Solution {
  // you need treat x as an unsigned value
  def hammingWeight(x: Int): Int = {
    var n = x
    n = n - ((n >> 1) & 0x55555555);
    n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
    n = (n + (n >> 4)) & 0x0f0f0f0f;
    n = n + (n >> 8);
    n = n + (n >> 16);
    n & 0x3f;
  }
}
// @lc code=end
