/*
 * @lc app=leetcode.cn id=328 lang=scala
 *
 * [328] 奇偶链表
 */
package Q328
class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}
// @lc code=start
object Solution {
  def oddEvenList(head: ListNode): ListNode = {

    @annotation.tailrec
    def helper(p: ListNode, odd: ListNode, even: ListNode, isOdd: Boolean): (ListNode, ListNode) = {
      Option(p) match {
        case None => {
          (odd, even)
        }
        case Some(node) if isOdd => {
          odd.next = node
          helper(node.next, node, even, false)
        }
        case Some(node) => {
          even.next = node
          helper(node.next, odd, node, true)
        }
      }
    }

    val oddHead = new ListNode
    val evenHead = new ListNode
    val (oddTail, evenTail) = helper(head, oddHead, evenHead, true)
    evenTail.next = null
    oddTail.next = evenHead.next
    oddHead.next
  }
}
// @lc code=end
