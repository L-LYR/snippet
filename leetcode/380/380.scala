/*
 * @lc app=leetcode.cn id=380 lang=scala
 *
 * [380] O(1) 时间插入、删除和获取随机元素
 */
package Q380

// @lc code=start
class RandomizedSet() {
  private val s = collection.mutable.Map.empty[Int, Int]
  private val a = collection.mutable.ArrayBuffer.empty[Int]

  def insert(v: Int): Boolean = {
    s.get(v)
      .map(_ => false)
      .getOrElse(({
        a.addOne(v)
        s.update(v, a.length - 1)
        true
      }))
  }

  def remove(v: Int): Boolean = {
    s.get(v)
      .map(i => {
        a.update(i, a.last)
        s.update(a.last, i)
        a.remove(a.length - 1)
        s.remove(v)
        true
      })
      .getOrElse(false)
  }

  def getRandom(): Int = {
    a(util.Random.nextInt(a.length))
  }

}
// @lc code=end
