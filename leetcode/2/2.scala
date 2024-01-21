/*
 * @lc app=leetcode.cn id=2 lang=scala
 *
 * [2] 两数相加
 */
package Q2

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

// @lc code=start
object Solution {
  def addTwoNumbers(l1: ListNode, l2: ListNode, carry: Int = 0): ListNode = {
    if (l1 == null && l2 == null) {
      if (carry > 0) {
        ListNode(carry)
      } else {
        null
      }
    } else if (l1 == null) {
      addTwoNumbers(l2, l1, carry)
    } else if (l2 == null) {
      val v = l1.x + carry
      l1.x = v % 10
      l1.next = addTwoNumbers(l1.next, null, v / 10)
      l1
    } else {
      val v = l1.x + l2.x + carry
      l1.x = v % 10
      l1.next = addTwoNumbers(l1.next, l2.next, v / 10)
      l1
    }
  }
}
// @lc code=end
