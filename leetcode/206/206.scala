/*
 * @lc app=leetcode.cn id=206 lang=scala
 *
 * [206] 反转链表
 */
package Q206

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

// @lc code=start
object Solution {
  def reverseList(head: ListNode): ListNode = {
    @annotation.tailrec
    def helper(p: ListNode, last: ListNode): ListNode = {
      p match {
        case null => last
        case _ => {
          val next = p.next
          p.next = last
          helper(next, p)
        }
      }
    }
    helper(head, null)
  }
}
// @lc code=end
