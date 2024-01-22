/*
 * @lc app=leetcode.cn id=234 lang=scala
 *
 * [234] 回文链表
 */
package Q234

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

// @lc code=start
object Solution {
  def isPalindrome(head: ListNode): Boolean = {
    @annotation.tailrec
    def go(left: ListNode, right: ListNode): Boolean = {
      if (left == null || right == null) true
      else {
        if (left.x != right.x) false
        else go(left.next, right.next)
      }
    }

    if (head == null || head.next == null) true
    else {
      val right = splitList(head, head.next)
      val left = reverseList(head)

      go(left, right)
    }
  }

  @annotation.tailrec
  def splitList(slow: ListNode, fast: ListNode): ListNode = {
    if (fast.next == null) {
      val right = slow.next
      slow.next = null
      right
    } else if (fast.next.next == null) {
      val right = slow.next.next
      slow.next = null
      right
    } else {
      splitList(slow.next, fast.next.next)
    }
  }

  def reverseList(head: ListNode): ListNode = {
    @annotation.tailrec
    def go(curr: ListNode, next: ListNode): ListNode = {
      if (curr != null) {
        val n = curr.next
        curr.next = next
        go(n, curr)
      } else {
        next
      }
    }

    go(head, null)
  }
}
// @lc code=end
