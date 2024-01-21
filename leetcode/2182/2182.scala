/*
 * @lc app=leetcode.cn id=2182 lang=scala
 *
 * [2182] 构造限制重复的字符串
 */
package Q2182

// @lc code=start
object Solution {
  def repeatLimitedString(s: String, repeatLimit: Int): String = {
    val count = s.groupMapReduce(identity)(_ => 1)(_ + _)
    val ans = new StringBuilder()

    @annotation.tailrec
    def helper(c: Option[Char], used: Map[Char, Int]): String = {
      @annotation.tailrec
      def nextAlpha(c: Char): Option[Char] = {
        if (c == 'a') None
        else {
          val nc = (c - 1).toChar
          count.get(nc) match {
            case Some(n) if used.getOrElse(nc, 0) < n => Some(nc)
            case _                                    => nextAlpha(nc)
          }
        }
      }
      c match {
        case None => ans.toString()
        case Some(c) =>
          count.get(c) match {
            case None => helper(nextAlpha(c), used)
            case Some(n) => {
              val remain = n - used.getOrElse(c, 0)
              val k = math.min(remain, repeatLimit)
              ans.append(c.toString * k)
              if (k == remain) {
                val updatedRecord = used ++ Map((c, n))
                val nc = nextAlpha(c)
                helper(nc, updatedRecord)
              } else {
                nextAlpha(c) match {
                  case None => ans.toString()
                  case Some(nc) => {
                    ans.append(nc)
                    val updatedRecord =
                      used ++ Map(
                        (c, k + used.getOrElse(c, 0)),
                        (nc, 1 + used.getOrElse(nc, 0))
                      )
                    helper(Some(c), updatedRecord)
                  }
                }
              }
            }
          }
      }
    }
    helper(Some('z'), Map.empty)
  }
}
// @lc code=end
