/*
 * @lc app=leetcode.cn id=56 lang=scala
 *
 * [56] 合并区间
 */
package Q56

// @lc code=start
object Solution {
  import scala.collection.mutable.ArrayBuffer
  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    // intervals
    //   .foldLeft(
    //     Set.empty[(Int, Int)]
    //   )({
    //     case (acc, Array(l, r)) => {
    //       val (needMerge, rest) = acc.partition(i => i._2 > l - 1 && i._1 <= r)
    //       rest + needMerge.foldLeft((l, r)) { case ((l, r), (cl, cr)) =>
    //         (l.min(cl), r.max(cr))
    //       }
    //     }
    //   })
    //   .toArray
    //   .map(p => Array(p._1, p._2))
    //   .toArray
    intervals
      .sortInPlaceBy(_(0))
      .foldLeft(ArrayBuffer[Array[Int]]())({ case (buf, Array(l, r)) =>
        buf.lastOption match {
          case Some(Array(ll, rr)) if rr >= l => {
            buf.last.update(1, math.max(rr, r))
            buf
          }
          case _ => buf.append(Array(l, r))
        }
      })
      .toArray
  }
}
// @lc code=end
