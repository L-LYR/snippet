/*
 * @lc app=leetcode.cn id=24 lang=scala
 *
 * [24] 两两交换链表中的节点
 */
package Q24

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}
// @lc code=start
object Solution {

  def swapPairs(head: ListNode): ListNode = {
    if (head == null || head.next == null) {
      head
    } else {
      val prev = head
      val curr = head.next
      prev.next = swapPairs(curr.next)
      curr.next = prev
      curr
    }
  }
}
// @lc code=end
