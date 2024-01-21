/*
 * @lc app=leetcode.cn id=19 lang=scala
 *
 * [19] 删除链表的倒数第 N 个结点
 */
package Q19

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

// @lc code=start
object Solution {
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    @annotation.tailrec
    def count(head: ListNode, n: Int = 0): Int = head match {
      case null => n
      case _    => count(head.next, 1 + n)
    }

    @annotation.tailrec
    def helper(head: ListNode, i: Int = 0): Unit = {
      if (i == 1) {
        head.next = head.next.next
      } else {
        helper(head.next, i - 1)
      }
    }

    val dummy = new ListNode(0, head)
    helper(dummy, count(dummy) - n)
    dummy.next
  }
}
// @lc code=end
