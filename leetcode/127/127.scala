/*
 * @lc app=leetcode.cn id=127 lang=scala
 *
 * [127] 单词接龙
 */
package Q127

// @lc code=start
object Solution {
  def ladderLength(beginWord: String, endWord: String, wordList: List[String]): Int = {
    import scala.collection.immutable.Queue

    val s = Set.from(wordList)
    if (!s.contains(endWord)) {
      0
    } else {
      @annotation.tailrec
      def bfs(q: Queue[(String, Int)], ss: Set[String]): Int = {
        q.dequeueOption match {
          case None => 0
          case Some(((s, k), nq)) => {
            val next = for {
              i <- 0 until s.size
              c <- 'a' to 'z'
              if (s(i) != c)
              val ns = s.updated(i, c)
              if (ss.contains(ns))
            } yield ns
            next.find(_ == endWord) match {
              case Some(_) => k + 1
              case None    => bfs(nq.enqueueAll(next.map((_, k + 1))), ss -- next)
            }
          }
        }
      }
      bfs(Queue((beginWord, 1)), s)
    }
  }
}
// @lc code=end
