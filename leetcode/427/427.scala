/*
 * @lc app=leetcode.cn id=427 lang=scala
 *
 * [427] 建立四叉树
 */
package Q427

class Node(var _value: Boolean, var _isLeaf: Boolean) {
  var value: Int = _value
  var isLeaf: Boolean = _isLeaf
  var topLeft: Node = null
  var topRight: Node = null
  var bottomLeft: Node = null
  var bottomRight: Node = null
}

// @lc code=start
object Solution {
  def construct(grid: Array[Array[Int]]): Node = {
    val m = grid.size
    val n = grid(0).size
    val prefix_sum = grid.scanLeft(new Array[Int](n + 1))((prev, cur) =>
      cur.scanLeft(0)((acc, x) => acc + x).zip(prev).map(p => p._1 + p._2)
    )
    def helper(x1: Int, y1: Int, x2: Int, y2: Int): Node = {
      val region_sum = prefix_sum(x2)(y2) - prefix_sum(x2)(y1) -
        prefix_sum(x1)(y2) + prefix_sum(x1)(y1)
      if (region_sum == (x2 - x1) * (y2 - y1) * grid(x1)(y1)) {
        new Node(grid(x1)(y1) == 1, true)
      } else {
        val nx = (x2 - x1) / 2 + x1;
        val ny = (y2 - y1) / 2 + y1;
        val root = new Node(grid(x1)(y1) == 1, false)
        root.topLeft = helper(x1, y1, nx, ny)
        root.topRight = helper(x1, ny, nx, y2)
        root.bottomLeft = helper(nx, y1, x2, ny)
        root.bottomRight = helper(nx, ny, x2, y2)
        root
      }
    }
    helper(0, 0, m, n)
  }
}
// @lc code=end
