/*
 * @lc app=leetcode.cn id=207 lang=scala
 *
 * [207] 课程表
 */
package Q207

// @lc code=start
object Solution {
  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    import scala.collection.immutable.Queue
    val in = prerequisites.foldLeft(new Array[Int](numCourses)) { case (in, Array(u, v)) =>
      in.updated(v, in(v) + 1)
    }
    val g = prerequisites.groupMapReduce(_(0))(p => List(p(1)))(_ ++ _)
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
    topoSort(Queue.from(init), init).size == numCourses
  }
}
// @lc code=end
