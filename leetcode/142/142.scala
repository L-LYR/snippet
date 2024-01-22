/*
 * @lc app=leetcode.cn id=142 lang=scala
 *
 * [142] 环形链表 II
 */
package Q142

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

// @lc code=start
object Solution {
  def detectCycle(head: ListNode): ListNode = {
    @annotation.tailrec
    def locate(p: ListNode, slow: ListNode): ListNode = {
      if (p != slow) locate(p.next, slow.next) else p
    }

    @annotation.tailrec
    def helper(slow: ListNode, fast: ListNode): ListNode = {
      if (fast != null && fast.next != null) {
        val nfast = fast.next.next
        val nslow = slow.next
        if (nslow == nfast) {
          locate(head, nslow)
        } else {
          helper(nslow, nfast)
        }
      } else {
        null
      }
    }

    if (head != null && head.next != null) { helper(head, head) }
    else { null }
  }
}
// @lc code=end
