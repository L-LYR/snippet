/*
 * @lc app=leetcode.cn id=23 lang=scala
 *
 * [23] 合并 K 个升序链表
 */
package Q23

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

// @lc code=start
object Solution {
  import scala.collection.mutable.PriorityQueue
  def mergeKLists(lists: Array[ListNode]): ListNode = {
    val q =
      new PriorityQueue[ListNode]()(Ordering.by[ListNode, Int](_.x).reverse)

    lists.filter(_ != null).foreach(q.addOne(_))

    @annotation.tailrec
    def helper(last: ListNode): Unit = {
      if (q.length > 0) {
        val node = q.dequeue()
        last.next = node
        if (node.next != null) {
          q.enqueue(node.next)
        }
        helper(node)
      }
    }

    val dummy = new ListNode()
    helper(dummy)
    dummy.next
  }
}
// @lc code=end
