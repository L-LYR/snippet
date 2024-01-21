/*
 * @lc app=leetcode.cn id=86 lang=scala
 *
 * [86] 分隔链表
 */
package Q86

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

// @lc code=start
object Solution {
  def partition(head: ListNode, x: Int): ListNode = {
    val left_dummy = new ListNode()
    val right_dummy = new ListNode()

    @annotation.tailrec
    def helper(
        head: ListNode,
        left_tail: ListNode,
        right_tail: ListNode
    ): Unit = {
      if (head != null) {
        val rest = head.next
        head.next = null
        if (head.x < x) {
          left_tail.next = head
          helper(rest, head, right_tail)
        } else {
          right_tail.next = head
          helper(rest, left_tail, head)
        }
      } else {
        left_tail.next = right_dummy.next
      }
    }

    helper(head, left_dummy, right_dummy)
    left_dummy.next
  }
}
// @lc code=end
