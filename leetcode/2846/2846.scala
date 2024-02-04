/*
 * @lc app=leetcode.cn id=2846 lang=scala
 *
 * [2846] 边权重均等查询
 */
package Q2846

// @lc code=start
// MLE: 720/733
object Solution {
  def minOperationsQueries(
      n: Int,
      edges: Array[Array[Int]],
      queries: Array[Array[Int]]
  ): Array[Int] = {
    import scala.collection.mutable.ArrayBuffer
    val g = ArrayBuffer.fill(n)(ArrayBuffer.empty[(Int, Int)])
    edges.iterator.foreach { case Array(u, v, w) =>
      g(u).append((v, w - 1))
      g(v).append((u, w - 1))
    }
    val m = Integer.SIZE - Integer.numberOfLeadingZeros(n)
    val f = ArrayBuffer.fill(n, m)(-1)
    val depth = ArrayBuffer.fill(n)(0)
    val count = ArrayBuffer.fill(n, n, 26)(0)
    val queryCount = ArrayBuffer.fill(26)(0)

    def dfs(x: Int, fa: Int): Unit = {
      f(x)(0) = fa
      g(x).filter(_._1 != fa).foreach {
        case (y, w) => {
          count(y)(0)(w) = 1
          depth(y) = depth(x) + 1
          dfs(y, x)
        }
      }
    }
    dfs(0, -1)

    @annotation.tailrec
    def getKthAncestor(node: Int, k: Int): Int = {
      if (node == -1 || k == 0) {
        node
      } else {
        val p = Integer.numberOfTrailingZeros(k)
        (0 until 26).foreach(j => queryCount(j) += count(node)(p)(j))
        getKthAncestor(f(node)(p), k & (k - 1))
      }
    }

    @annotation.tailrec
    def getLCA(x: Int, y: Int, i: Int = m - 1): Int = {
      if (depth(x) > depth(y)) {
        getLCA(y, x)
      } else if (depth(x) != depth(y)) {
        val yp = getKthAncestor(y, depth(y) - depth(x))
        getLCA(x, yp)
      } else if (x == y) {
        x
      } else if (i >= 0) {
        if (f(x)(i) != f(y)(i)) {
          (0 until 26).foreach(j => queryCount(j) += count(y)(i)(j) + count(x)(i)(j))
          getLCA(f(x)(i), f(y)(i), i - 1)
        } else {
          getLCA(x, y, i - 1)
        }
      } else {
        (0 until 26).foreach(j => queryCount(j) += count(y)(0)(j) + count(x)(0)(j))
        f(x)(0)
      }
    }

    for {
      i <- 0 until m - 1
      x <- 0 until n
      val p = f(x)(i)
      if p != -1
    } {
      f(x)(i + 1) = f(p)(i)
      (0 until 26).foreach(j => count(x)(i + 1)(j) += count(x)(i)(j) + count(p)(i)(j))
    }

    queries.collect { case Array(x, y) =>
      queryCount.mapInPlace(_ => 0)
      val p = getLCA(x, y)
      val path = depth(x) + depth(y) - 2 * depth(p)
      path - queryCount.maxOption.getOrElse(0)
    }.toArray
  }
}
// @lc code=end
