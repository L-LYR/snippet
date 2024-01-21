/*
 * @lc app=leetcode.cn id=82 lang=scala
 *
 * [82] 删除排序链表中的重复元素 II
 */
package Q82

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

// @lc code=start
object Solution {
  def deleteDuplicates(head: ListNode): ListNode = {
    @annotation.tailrec
    def deleteDuplicateX(head: ListNode, x: Int): ListNode = {
      if (head == null || head.x != x) { head }
      else { deleteDuplicateX(head.next, x) }
    }

    @annotation.tailrec
    def helper(head: ListNode, prev: ListNode): Unit = {
      if (head != null) {
        val rest = deleteDuplicateX(head.next, head.x)
        if (rest == head.next) {
          prev.next = head
          helper(rest, head)
        } else {
          prev.next = rest
          helper(rest, prev)
        }
      }
    }

    val dummy = ListNode(0, head)
    helper(head, dummy)
    dummy.next
  }
}
// @lc code=end
