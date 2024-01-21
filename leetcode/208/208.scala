/*
 * @lc app=leetcode.cn id=208 lang=scala
 *
 * [208] 实现 Trie (前缀树)
 */
package Q208

// @lc code=start
class Trie() {
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

  @annotation.tailrec
  private def search(word: Seq[Char], node: Node): Boolean =
    word match {
      case Nil => node.count > 0
      case c +: cs =>
        node.branch.get(c) match {
          case None       => false
          case Some(next) => search(cs, next)
        }
    }

  @annotation.tailrec
  private def startsWith(prefix: Seq[Char], node: Node): Boolean =
    prefix match {
      case Nil => true
      case c +: cs =>
        node.branch.get(c) match {
          case None       => false
          case Some(next) => startsWith(cs, next)
        }
    }

  def insert(word: String) {
    root = insert(word.toSeq, root)
  }

  def search(word: String): Boolean = {
    search(word.toSeq, root)
  }

  def startsWith(prefix: String): Boolean = {
    startsWith(prefix.toSeq, root)
  }
}
// @lc code=end
