/*
 * @lc app=leetcode.cn id=211 lang=scala
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */
package Q211

// @lc code=start
class WordDictionary() {
  case class Node(count: Int, branch: Map[Char, Node])

  var root = Node(0, Map.empty)

  private def insert(word: Seq[Char], node: Node): Node =
    word match {
      case Nil => Node(node.count + 1, node.branch)
      case c +: cs =>
        node.branch.get(c) match {
          case None =>
            Node(
              node.count,
              node.branch + (c -> insert(cs, Node(0, Map.empty)))
            )
          case Some(next) =>
            Node(node.count, node.branch + (c -> insert(cs, next)))
        }
    }

  private def search(word: Seq[Char], node: Node): Boolean =
    word match {
      case Nil => node.count > 0
      case c +: cs =>
        c match {
          case '.' => node.branch.exists(p => search(cs, p._2))
          case _ =>
            node.branch.get(c) match {
              case None       => false
              case Some(next) => search(cs, next)
            }
        }

    }

  def addWord(word: String) {
    root = insert(word.toSeq, root)
  }

  def search(word: String): Boolean = {
    search(word.toSeq, root)
  }

}
// @lc code=end
