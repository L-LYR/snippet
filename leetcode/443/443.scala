/*
 * @lc app=leetcode.cn id=443 lang=scala
 *
 * [443] 压缩字符串
 */
package Q443

// @lc code=start
object Solution {
  def compress(chars: Array[Char]): Int = {
    @annotation.tailrec
    def helper(i: Int, j: Int, k: Int): Int = {
      if (i < chars.size) {
        if (k == chars.size || (k < chars.size && chars(k) != chars(i))) {
          val n = k - i
          chars.update(j, chars(i))
          if (n > 1) {
            val s = n.toString()
            (1 to s.size).foreach(i => chars.update(j + i, s(i - 1)))
            helper(k, j + 1 + s.size, k)
          } else {
            helper(k, j + 1, k)
          }
        } else {
          helper(i, j, k + 1)
        }
      } else {
        j
      }
    }

    helper(0, 0, 0)
  }
}
// @lc code=end
