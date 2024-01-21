/*
 * @lc app=leetcode.cn id=67 lang=scala
 *
 * [67] 二进制求和
 */
package Q67

// @lc code=start
object Solution {
  import scala.collection.mutable.ArrayBuffer
  def addBinary(a: String, b: String): String = {
    val r = ArrayBuffer[Char]()
    val c = a.reverse
      .zipAll(b.reverse, '0', '0')
      .map({ case (x, y) => x.toInt - 48 + y.toInt - 48 })
      .foldLeft(0)({
        case (c, s) => {
          r.addOne(((s + c) % 2 + 48).toChar)
          (s + c) / 2
        }
      })
    if (c > 0) r.addOne((c + 48).toChar)
    r.reverse.mkString
  }
}
// @lc code=end
