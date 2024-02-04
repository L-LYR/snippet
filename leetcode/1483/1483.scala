/*
 * @lc app=leetcode.cn id=1483 lang=scala
 *
 * [1483] 树节点的第 K 个祖先
 */
package Q1483

// @lc code=start
class TreeAncestor(_n: Int, _parent: Array[Int]) {
  import scala.collection.mutable.ArrayBuffer
  val m = Integer.SIZE - Integer.numberOfLeadingZeros(_n)
  val f = ArrayBuffer.fill(_n, m)(-1)

  _parent.iterator.zipWithIndex.foreach { case (x, i) => f(i)(0) = x }
  for {
    i <- 0 until m - 1
    x <- 0 until _n
    val p = f(x)(i)
    if p != -1
  } { f(x)(i + 1) = f(p)(i) }

  @annotation.tailrec
  final def getKthAncestor(node: Int, k: Int): Int = {
    if (node == -1 || k == 0) {
      node
    } else {
      getKthAncestor(f(node)(Integer.numberOfTrailingZeros(k)), k & (k - 1))
    }
  }
}
// @lc code=end
