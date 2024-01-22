/*
 * @lc app=leetcode.cn id=394 lang=scala
 *
 * [394] 字符串解码
 */
package Q394

// @lc code=start
object Solution {
  import scala.collection.mutable.Stack
  def decodeString(s: String): String = {
    val ns = Stack.empty[Int]
    val ss = Stack.empty[String]
    s.foldLeft(("", 0)) {
      case ((cur, x), c) if c.isDigit  => (cur, x * 10 + (c - '0').toInt)
      case ((cur, x), c) if c.isLetter => (cur :+ c, x)
      case ((cur, x), c) if c == '[' => {
        ns.push(x)
        ss.push(cur)
        ("", 0)
      }
      case ((cur, x), c) if c == ']' => (ss.pop() ++ (cur * ns.pop()), 0)
    }._1
  }
}
// @lc code=end
