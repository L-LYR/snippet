/*
 * @lc app=leetcode.cn id=649 lang=scala
 *
 * [649] Dota2 参议院
 */
package Q649

// @lc code=start
object Solution {
  def predictPartyVictory(senate: String): String = {
    @annotation.tailrec
    def prepare(i: Int, r: List[Int], d: List[Int]): (List[Int], List[Int]) = {
      if (i == senate.size) {
        (r, d)
      } else if (senate(i) == 'R') {
        prepare(i + 1, r :+ i, d)
      } else {
        prepare(i + 1, r, d :+ i)
      }
    }
    val n = senate.size
    val (r, d) = prepare(0, List.empty, List.empty)
    @annotation.tailrec
    def helper(r: List[Int], d: List[Int]): String = {
      (r, d) match {
        case (x :: xs, y :: ys) if x < y => helper(xs :+ (x + n), ys)
        case (x :: xs, y :: ys)          => helper(xs, ys :+ (y + n))
        case (Nil, _)                    => "Dire"
        case (_, Nil)                    => "Radiant"
      }
    }
    helper(r, d)
  }
}
// @lc code=end
