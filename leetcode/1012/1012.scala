/*
 * @lc app=leetcode.cn id=1012 lang=scala
 *
 * [1012] 至少有 1 位重复的数字
 */
package Q1012

// @lc code=start
object Solution {
  import scala.collection.mutable.HashMap

  def memorize[I, O](f: I => O): I => O = new HashMap[I, O]() {
    override def apply(key: I) = getOrElseUpdate(key, f(key))
  }

  def numDupDigitsAtMostN(n: Int): Int = {
    val s = n.toString
    lazy val dfs: ((Int, Set[Char], Boolean, Boolean)) => Int = memorize {
      case (i, used, ub, ok) => {
        if (i == s.size) {
          if (ok) 1 else 0
        } else {
          (if (!ok) dfs(i + 1, used, false, false) else 0) + {
            val lo = if (ok) '0' else '1'
            val hi = if (ub) s(i) else '9'
            (lo to hi).foldLeft(0) {
              case (acc, c) if !used.contains(c) =>
                acc + dfs(i + 1, used + c, ub && c == hi, true)
              case (acc, _) => acc
            }
          }
        }
      }
    }

    n - dfs(0, Set.empty, true, false)
  }
}
// @lc code=end
