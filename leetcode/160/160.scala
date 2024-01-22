/*
 * @lc app=leetcode.cn id=160 lang=scala
 *
 * [160] 相交链表
 */
package Q160

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

// @lc code=start
object Solution {
  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
    @annotation.tailrec
    def helper(p: ListNode, q: ListNode): ListNode =
      (p, q) match {
        case (p, q) if p == q => p
        case (null, q)        => helper(headB, q.next)
        case (p, null)        => helper(p.next, headA)
        case (p, q)           => helper(p.next, q.next)
      }
    helper(headA, headB)
  }
}
// @lc code=end
