/*
 * @lc app=leetcode.cn id=547 lang=scala
 *
 * [547] 省份数量
 */
package Q547

// @lc code=start
object Solution {
  def findCircleNum(isConnected: Array[Array[Int]]): Int = {
    val parent = isConnected.indices.toArray

    @scala.annotation.tailrec
    def find(i: Int): Int = if (parent(i) != i) find(parent(i)) else i

    for {
      i <- isConnected.indices
      j <- isConnected.indices
      if isConnected(i)(j) == 1
    } { parent(find(i)) = find(j) }

    parent.zipWithIndex.count(x => x._1 == x._2)
  }
}
// @lc code=end
