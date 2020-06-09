package LongestConsecutiveSequence

/**
  * Created by iodone on {19-10-25}.
  */

/**
  * 解题报告
  * 
  * 说明：空间换时间
  * 
  * 思路：通过hash表去重，然后依次遍历hashTable, 记录当前遍历的连续序列长度，最后比较所有的连续序列长度大小即可
  */

object Solution {
  import scala.math.max
  import scala.collection.immutable.HashSet
  def longestConsecutive(nums: Array[Int]): Int = {
    val hashSet = HashSet(nums: _*)
    var maxLen = 0
    for (x <- hashSet) {
      var next = x
      var curLen = 0
      while(hashSet(next)) {
        curLen += 1
        next += 1
      }
      maxLen = max(maxLen, curLen)
    }
    maxLen
  }

  def main(args: Array[String]): Unit = {
    println(longestConsecutive(Array(9,8,7,7,0,-3,-1,-5)))
  }
}
