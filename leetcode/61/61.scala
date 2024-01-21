/*
 * @lc app=leetcode.cn id=61 lang=scala
 *
 * [61] 旋转链表
 */
package Q61

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

// @lc code=start
object Solution {
  def rotateRight(head: ListNode, k: Int): ListNode = {
    @annotation.tailrec
    def count(
        head: ListNode,
        prev: ListNode = null,
        n: Int = 0
    ): (Int, ListNode) = head match {
      case null => (n, prev)
      case _    => count(head.next, head, 1 + n)
    }

    @annotation.tailrec
    def locate(head: ListNode, n: Int): (ListNode, ListNode) = {
      if (head != null && n > 1) {
        locate(head.next, n - 1)
      } else if (n == 1) {
        (head, head.next)
      } else {
        (null, null)
      }
    }

    if (head == null) {
      null
    } else {
      val (n, tail) = count(head)
      val new_k = (k + n) % n
      if (new_k == 0) {
        head
      } else {
        val (prev, kth) = locate(head, n - new_k)
        tail.next = head
        prev.next = null
        kth
      }
    }
  }
}
// @lc code=end
