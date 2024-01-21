/*
 * @lc app=leetcode.cn id=92 lang=scala
 *
 * [92] 反转链表 II
 */
package Q92

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

// @lc code=start
object Solution {
  def reverseBetween(head: ListNode, left: Int, right: Int): ListNode = {
    @annotation.tailrec
    def reverseFirstK(
        head: ListNode,
        n: Int,
        prev: ListNode
    ): (ListNode, ListNode) =
      if (head != null && n > 0) {
        val rest = head.next
        head.next = prev
        reverseFirstK(rest, n - 1, head)
      } else {
        (prev, head)
      }

    if (left == 1) {
      val (new_head, rest) = reverseFirstK(head, right, null)
      head.next = rest
      new_head
    } else {
      head.next = reverseBetween(head.next, left - 1, right - 1)
      head
    }
  }
}
// @lc code=end
