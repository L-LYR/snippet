/*
 * @lc app=leetcode.cn id=49 lang=scala
 *
 * [49] 字母异位词分组
 */
package Q49

// @lc code=start
object Solution {
  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    // strs
    //   .map(_.sorted)
    //   .zipWithIndex
    //   .groupMap(_._1)(p => strs(p._2))
    //   .values
    //   .map(_.toList)
    //   .toList
    strs.groupBy(_.sorted).values.map(_.toList).toList
  }
}
// @lc code=end
