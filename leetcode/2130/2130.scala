/*
 * @lc app=leetcode.cn id=2130 lang=scala
 *
 * [2130] 链表最大孪生和
 */
package Q2130
class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

// @lc code=start
object Solution {
  def pairSum(head: ListNode): Int = {
    @annotation.tailrec
    def midPos(slow: ListNode, fast: ListNode): ListNode = {
      if (fast != null && fast.next != null) {
        midPos(slow.next, fast.next.next)
      } else {
        slow
      }
    }

    val rightPart = midPos(head, head)

    @annotation.tailrec
    def reverseUntil(p: ListNode, lim: ListNode, last: ListNode): ListNode = {
      if (p == lim) {
        last
      } else {
        val next = p.next
        p.next = last
        reverseUntil(next, lim, p)
      }
    }

    val reversedLeftPart = reverseUntil(head, rightPart, null)

    @annotation.tailrec
    def gotMaxPairSum(p: ListNode, q: ListNode, v: Int): Int = {
      if (p == null || q == null) {
        v
      } else {
        gotMaxPairSum(p.next, q.next, v max (p.x + q.x))
      }
    }

    gotMaxPairSum(rightPart, reversedLeftPart, Int.MinValue)
  }
}
// @lc code=end
