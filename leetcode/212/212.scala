/*
 * @lc app=leetcode.cn id=212 lang=scala
 *
 * [212] 单词搜索 II
 */
package Q212

// @lc code=start
object Solution {
  import scala.collection.mutable.Map
  class Trie() {
    val children = Map.empty[Char, Trie]
    var isTerminal = false
    def insert(word: String) = word
      .foldLeft(this)({ case (t, c) =>
        t.children.getOrElseUpdate(c, new Trie())
      })
      .isTerminal = true
    def child(prefix: Char): Option[Trie] =
      if (children.contains(prefix)) Some(children(prefix)) else None
  }

  def findWords(
      board: Array[Array[Char]],
      words: Array[String]
  ): List[String] = {
    val m = board.length
    val n = board(0).length
    val trie = new Trie()
    words.map(trie.insert(_))
    def dfs(i: Int, j: Int, node: Trie, prefix: String): Seq[String] = {
      if (i >= 0 && i < m && j >= 0 && j < n && board(i)(j) != '#') {
        val c = board(i)(j)
        board(i)(j) = '#'
        val newPrefix = prefix :+ c
        val found = node
          .child(c)
          .fold(Seq.empty[String])({ next =>
            (if (next.isTerminal) Seq(newPrefix) else Seq.empty) ++
              dfs(i + 1, j, next, newPrefix) ++
              dfs(i - 1, j, next, newPrefix) ++
              dfs(i, j + 1, next, newPrefix) ++
              dfs(i, j - 1, next, newPrefix)
          })
        board(i)(j) = c
        found
      } else {
        Seq.empty[String]
      }
    }

    (for (i <- 0 to m - 1; j <- 0 to n - 1)
      yield (i, j)).flatMap(p => dfs(p._1, p._2, trie, "")).distinct.toList
  }
}
// @lc code=end
