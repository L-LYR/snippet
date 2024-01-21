/*
 * @lc app=leetcode.cn id=148 lang=scala
 *
 * [148] 排序链表
 */
package Q148

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

// @lc code=start
object Solution {
  def split(head: ListNode): ListNode = {
    @annotation.tailrec
    def helper(slow: ListNode, fast: ListNode, prev: ListNode): ListNode = {
      if (fast == null || fast.next == null) {
        if (prev != null) prev.next = null
        slow
      } else {
        helper(slow.next, fast.next.next, slow)
      }
    }

    helper(head, head, null)
  }

  def merge(left: ListNode, right: ListNode): ListNode = {
    @annotation.tailrec
    def helper(left: ListNode, right: ListNode, tail: ListNode): Unit = {
      (left, right) match {
        case (l, null) => {
          tail.next = l
        }
        case (null, r) => {
          tail.next = r
        }
        case (l, r) if l.x < r.x => {
          tail.next = l
          helper(l.next, r, tail.next)
        }
        case (l, r) => {
          tail.next = r
          helper(l, r.next, tail.next)
        }
      }
    }
    val dummy = new ListNode()
    helper(left, right, dummy)
    dummy.next
  }

  def sortList(head: ListNode): ListNode = {
    if (head == null || head.next == null) {
      head
    } else {
      val right = split(head)
      merge(sortList(head), sortList(right))
    }

  }
}
// @lc code=end
