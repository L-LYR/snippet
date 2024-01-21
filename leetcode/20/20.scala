/*
 * @lc app=leetcode.cn id=20 lang=scala
 *
 * [20] 有效的括号
 */
package Q20

// @lc code=start
object Solution {
  import scala.collection.mutable.Stack
  val ls = Set('(', '[', '{')
  val ps = Map(')' -> '(', ']' -> '[', '}' -> '{')
  def isValid(s: String): Boolean = {
    val cs = Stack.empty[Char]
    s.forall({
      case c if ls.contains(c) => cs.push(c); true
      case c if ps.contains(c) && cs.size > 0 && cs.top == ps.get(c).get =>
        cs.pop(); true
      case _ => false
    }) && cs.size == 0
  }
}
// @lc code=end
