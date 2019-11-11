package FindDuplicateNumber

/**
  * Created by iodone on {19-11-11}.
  */

object Solution {
  def findDuplicate(nums: Array[Int]): Int = {
    val numsSorted = nums.sorted
    var next = numsSorted.head
    var ret = next
    for (x <- numsSorted.tail) {
      if (x == next) ret = x
      else next = x
    }
    ret
  }

  def main(args: Array[String]): Unit = {
    println(findDuplicate(Array(9,7,1,2,4,2, 8,2)))
  }
}
