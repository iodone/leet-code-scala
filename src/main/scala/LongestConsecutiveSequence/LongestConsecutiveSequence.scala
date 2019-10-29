package LongestConsecutiveSequence

/**
  * Created by iodone on {19-10-25}.
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
