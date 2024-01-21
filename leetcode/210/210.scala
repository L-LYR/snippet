/*
 * @lc app=leetcode.cn id=210 lang=scala
 *
 * [210] 课程表 II
 */
package Q210

// @lc code=start
object Solution {
  def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {
    import scala.collection.immutable.Queue
    val in = prerequisites.foldLeft(new Array[Int](numCourses)) { case (in, Array(u, v)) =>
      in.updated(u, in(u) + 1)
    }
    val g = prerequisites.groupMapReduce(_(1))(p => List(p(0)))(_ ++ _)
    @annotation.tailrec
    def topoSort(q: Queue[Int], seq: List[Int]): List[Int] = {
      q.dequeueOption match {
        case None => seq
        case Some((u, nq)) => {
          val next =
            g.getOrElse(u, List.empty)
              .tapEach(v => in.update(v, in(v) - 1))
              .filter(v => in(v) == 0)
              .toList
          topoSort(nq.enqueueAll(next), seq ++ next)
        }
      }
    }
    val init = in.zipWithIndex.collect { case (x, i) if x == 0 => i }.toList
    val seq = topoSort(Queue.from(init), init)
    if (seq.size == numCourses) seq.toArray else Array.empty
  }
}
// @lc code=end
