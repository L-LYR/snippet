/*
 * @lc app=leetcode.cn id=21 lang=scala
 *
 * [21] 合并两个有序链表
 */

package Q21

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

// @lc code=start
object Solution {
  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
    // if (list1 == null) {
    //   list2
    // } else if (list2 == null) {
    //   list1
    // } else {
    //   if (list1.x < list2.x) {
    //     list1.next = mergeTwoLists(list1.next, list2)
    //     list1
    //   } else {
    //     list2.next = mergeTwoLists(list1, list2.next)
    //     list2
    //   }
    // }
    (list1, list2) match {
      case (null, _) => list2
      case (_, null) => list1
      case _ => {
        if (list1.x < list2.x) {
          new ListNode(list1.x, mergeTwoLists(list1.next, list2))
        } else {
          new ListNode(list2.x, mergeTwoLists(list1, list2.next))
        }
      }
    }
  }
}
// @lc code=end
