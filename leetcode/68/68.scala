/*
 * @lc app=leetcode.cn id=68 lang=scala
 *
 * [68] 文本左右对齐
 */
package Q68

// @lc code=start
object Solution {
  def fullJustify(words: Array[String], maxWidth: Int): List[String] = {
    words.toList
      .drop(1)
      .scanLeft((List(words(0)), words(0).length, true))({
        case ((line, size, _), word) if size + word.length + 1 > maxWidth =>
          (List(word), word.length, true)
        case ((line, size, _), word) =>
          (line :+ word, size + word.length + 1, false)
      }) // group each line by sum of length
      .appended((List.empty[String], 0, true))
      .sliding(2)
      .collect({ case (line, _, _) :: (_, _, true) :: rest => line })
      .toList // take each line
      .tails
      .collect({
        case line :: _ :: rest => {
          line match {
            // one word one line
            case word :: Nil => word ++ (" " * (maxWidth - word.length))
            // normal case
            case words => {
              val remain = maxWidth - words.map(_.length).sum
              val nBlank = remain / (words.size - 1)
              val nExtra = remain % (words.size - 1) // extra blanks
              words
                .drop(1)
                .foldLeft[(String, Int)]((words(0), nExtra))({
                  case ((line, nExtra), word) if nExtra > 0 => {
                    (line ++ (" " * (nBlank + 1)) ++ (word), nExtra - 1)
                  }
                  case ((line, _), word) => {
                    (line ++ (" " * nBlank) ++ (word), 0)
                  }
                })
                ._1
            }
          }
        }
        case lastLine :: Nil => { // last line is special
          val line = lastLine.mkString(" ")
          line ++ (" " * (maxWidth - line.length))
        }
      })
      .toList
  }
}
// @lc code=end
