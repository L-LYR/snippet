/*
 * @lc app=leetcode.cn id=383 lang=scala
 *
 * [383] 赎金信
 */
package Q383

// @lc code=start
object Solution {
    def canConstruct(ransomNote: String, magazine: String): Boolean = {
        ransomNote.toCharArray().diff(magazine.toCharArray()).isEmpty
    }
}
// @lc code=end

