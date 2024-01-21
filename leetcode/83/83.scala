/*
 * @lc app=leetcode.cn id=83 lang=scala
 *
 * [83] 删除排序链表中的重复元素
 */
package Q83

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
    def helper(head: ListNode): Unit = {
      if (head != null) {
        head.next = deleteDuplicateX(head.next, head.x)
        helper(head.next)
      }
    }

    helper(head)
    head
  }
}
// @lc code=end
