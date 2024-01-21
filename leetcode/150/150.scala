/*
 * @lc app=leetcode.cn id=150 lang=scala
 *
 * [150] 逆波兰表达式求值
 */
package Q150

// @lc code=start
object Solution {
  import scala.collection.mutable.Stack
  def evalRPN(tokens: Array[String]): Int = {
    tokens
      .foldLeft(Stack.empty[Int])((ns, s) =>
        s match {
          case "+" => ns.drop(2).push(ns(1) + ns(0))
          case "-" => ns.drop(2).push(ns(1) - ns(0))
          case "*" => ns.drop(2).push(ns(1) * ns(0))
          case "/" => ns.drop(2).push(ns(1) / ns(0))
          case _   => ns.push(s.toInt)
        }
      )
      .head
  }
}
// @lc code=end
