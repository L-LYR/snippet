/*
 * @lc app=leetcode.cn id=2865 lang=scala
 *
 * [2865] 美丽塔 I
 */
package Q2865

// @lc code=start
object Solution {
  import scala.collection.mutable.Stack
  import scala.collection.mutable.ArrayBuffer
  def maximumSumOfHeights(maxHeights: List[Int]): Long = {
    val hs = maxHeights.toBuffer
    val s = Stack.empty[Int]
    val l = ArrayBuffer.fill(hs.size)(-1)
    val r = ArrayBuffer.fill(hs.size)(-1)
    hs.indices.foreach(i => {
      s.popWhile(j => hs(j) >= hs(i)).foreach(j => l(j) = i)
      s.push(i)
    })
    s.clear()
    hs.indices.reverse.foreach(i => {
      s.popWhile(j => hs(j) >= hs(i)).foreach(j => r(j) = i)
      s.push(i)
    })
    val pre = ArrayBuffer.fill(hs.size)(0.toLong)
    val suf = ArrayBuffer.fill(hs.size)(0.toLong)
    hs.indices.reverse.foreach(i => {
      l(i) match {
        case -1 => suf(i) = hs(i) * (hs.size - i).toLong
        case j  => suf(i) = hs(i) * (j - i).toLong + suf(j)
      }
    })
    hs.indices.foreach(i => {
      r(i) match {
        case -1 => pre(i) = hs(i) * (i + 1).toLong
        case j  => pre(i) = hs(i) * (i - j).toLong + pre(j)
      }
    })

    pre.iterator
      .zip(suf.iterator)
      .map(p => p._1 + p._2)
      .zip(hs.iterator)
      .map(p => p._1 - p._2)
      .max
  }
}
// @lc code=end
