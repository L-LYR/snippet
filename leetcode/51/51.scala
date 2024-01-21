/*
 * @lc app=leetcode.cn id=51 lang=scala
 *
 * [51] N 皇后
 */
package Q51

// @lc code=start
object Solution {
  def solveNQueens(n: Int): List[List[String]] = {
    def diagCk(ite: Iterator[Int]) =
      ite.zipWithIndex.map { case (i, x) => i - x }.distinct.length == n

    (0 until n).permutations
      .filter(arr => diagCk(arr.iterator) && diagCk(arr.reverseIterator))
      .map(_.iterator.map(k => ("." * n).updated(k, 'Q')).toList)
      .toList
  }
}
// @lc code=end
