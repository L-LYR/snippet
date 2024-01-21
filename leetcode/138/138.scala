/*
 * @lc app=leetcode.cn id=138 lang=scala
 *
 * [138] 随机链表的复制
 */

package Q138

class Node(var _value: Int) {
  var value: Int = _value
  var next: Node = null
  var random: Node = null
}

// @lc code=start
object Solution {
  def copyRandomList(head: Node): Node = {
    @annotation.tailrec
    def addNewNodeAsOriginNext(head: Node): Unit = head match {
      case null => {}
      case _ => {
        val rest = head.next
        head.next = new Node(head.value)
        head.next.next = rest
        addNewNodeAsOriginNext(rest)
      }
    }

    @annotation.tailrec
    def modifyNewNodeRandom(head: Node): Unit = head match {
      case null => {}
      case _ => {
        if (head.random != null) {
          head.next.random = head.random.next
        }
        modifyNewNodeRandom(head.next.next)
      }
    }

    @annotation.tailrec
    def splitFromOrigin(head: Node, prev: Node): Unit = head match {
      case null => {}
      case _ => {
        prev.next = head.next
        head.next = head.next.next
        splitFromOrigin(head.next, prev.next)
      }
    }

    val dummy = new Node(0)
    addNewNodeAsOriginNext(head)
    modifyNewNodeRandom(head)
    splitFromOrigin(head, dummy)
    dummy.next
  }
}
// @lc code=end
