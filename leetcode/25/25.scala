/*
 * @lc app=leetcode.cn id=25 lang=scala
 *
 * [25] K 个一组翻转链表
 */
package Q25

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

// @lc code=start
object Solution {
  def reverseKGroup(head: ListNode, k: Int): ListNode = {
    @annotation.tailrec
    def reverseFirstK(
        head: ListNode,
        n: Int,
        prev: ListNode = null
    ): (ListNode, ListNode) =
      if (head != null && n > 0) {
        val rest = head.next
        head.next = prev
        reverseFirstK(rest, n - 1, head)
      } else {
        (prev, head)
      }

    @annotation.tailrec
    def count(head: ListNode, n: Int = 0): Int = head match {
      case null => n
      case _    => count(head.next, 1 + n)
    }

    val dummy = new ListNode()
    (0 until (count(head) / k)).foldLeft((head, dummy))({
      case ((head, prev), _) => {
        val (new_head, rest) = reverseFirstK(head, k)
        head.next = rest
        prev.next = new_head
        (rest, head)
      }
    })
    dummy.next
  }
}
// @lc code=end
