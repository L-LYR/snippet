/*
 * @lc app=leetcode.cn id=2095 lang=scala
 *
 * [2095] 删除链表的中间节点
 */
package Q2095
class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}
// @lc code=start
object Solution {
  def deleteMiddle(head: ListNode): ListNode = {
    @annotation.tailrec
    def listLength(node: ListNode, acc: Int): Int =
      node match {
        case null => acc
        case _    => listLength(node.next, acc + 1)
      }

    @annotation.tailrec
    def deleteAtIndex(curIndex: Int, targetIndex: Int, node: ListNode): Unit =
      node match {
        case null                         => ()
        case n if n.next == null          => ()
        case n if curIndex == targetIndex => n.next = n.next.next
        case _                            => deleteAtIndex(curIndex + 1, targetIndex, node.next)
      }

    val length = listLength(head, 0)
    Option.when(length == 1)(null).getOrElse {
      deleteAtIndex(0, length / 2 - 1, head)
      head
    }
  }
}
// @lc code=end
