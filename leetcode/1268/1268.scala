/*
 * @lc app=leetcode.cn id=1268 lang=scala
 *
 * [1268] 搜索推荐系统
 */

// @lc code=start
object Solution {
  def suggestedProducts(products: Array[String], searchWord: String): List[List[String]] =
    products.sorted match {
      case sorted =>
        searchWord
          .scanLeft("")(_ + _)
          .tail
          .map(word => sorted.filter(_ startsWith word).take(3).toList)
          .toList
    }
}
// @lc code=end
