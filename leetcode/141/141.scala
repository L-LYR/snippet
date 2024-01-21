/*
 * @lc app=leetcode.cn id=141 lang=scala
 *
 * [141] 环形链表
 */

package Q141

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

// @lc code=start
object Solution {
  def hasCycle(head: ListNode): Boolean = {
    @annotation.tailrec
    def helper(slow: ListNode, fast: ListNode): Boolean = {
      slow == fast ||
      (fast != null && fast.next != null && helper(slow.next, fast.next.next))
    }
    head != null && head.next != null && helper(head, head.next)
  }
}
// @lc code=end
