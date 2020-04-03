package ThreeSum

/**
  * 解题报告
  * 
  * 思路一：枚举，转化为twosum的问题，由于具有对称性，循环可以从前一个加数的后一个位置开始寻找下一个加数，
  * 但是这样也不能保障重复的问题，因为数组中可能存在重复的数字，每次寻找到一组符合要求的加数后排序记录。
  * 但是会TLE，时间复杂度O(n3)
  * 
  * 思路二：排序后，选出target，依次寻找另外两个加数，由于排序可以从left和right边界开始寻找，根据剩下两个加数和
  * 与target比较，选择移动left还是right。同时在遍历target和左右两个加数的时候注意跳过重复数字，由于排序过重复的
  * 数字会连续，依次跳过即可。时间复杂度 O(n2)
  */

object Solution {
  def threeSum(nums: Array[Int]): List[List[Int]] = {

    var tag = Set[String]()
    var threeSumList = List[(Int, Int, Int)]()

    for (k <- 0 until nums.length) {
      val target = 0 - nums(k)
      for(i <- k+1 until nums.length) {
        val left = target - nums(i)
        for (j <- i+1 until nums.length) {
          if (left == nums(j)) {
            val tupleKey = List(nums(k), nums(i), nums(j)).sorted.mkString
            if (!tag.contains(tupleKey)) {
              threeSumList = threeSumList ::: (nums(k), nums(i), nums(j)):: List[(Int, Int, Int)]()
              tag = tag + tupleKey
            }
          }
        }
      }
    }

    threeSumList.map(x => List(x._1, x._2, x._3))
  }

  def main(args: Array[String]) = {
    println(threeSum(Array(-1, 0, 1, 2, -1, -4)))
    println(threeSum(Array(0, 0, 0, 0)))
  }
}