package FirstMissingPositive

/**
  * Created by iodone on {19-9-12}.
  */

object Solution {
  def firstMissingPositive(nums: Array[Int]): Int = {
    if (nums.isEmpty) 1
    else {
      for (i <- 0 until nums.length) {
        while (nums(i) > 0 && nums(i) <= nums.length && nums(i) != nums(nums(i) - 1)) {
          val tmp = nums(nums(i)-1)
          nums(nums(i)-1) = nums(i)
          nums(i) = tmp
        }
      }
      val xs = (0 until nums.length).takeWhile(i => nums(i) == i+1)
      if (xs.isEmpty) 1 else xs.last + 2
    }
  }

  def main(args: Array[String]): Unit = {
//    println(firstMissingPositive(Array(3,4,-1,1)))
//    println(firstMissingPositive(Array(7,8,9,11,12)))
//    println(firstMissingPositive(Array(1,2,4,11,12)))
//    println(firstMissingPositive(Array(0,2,2,1,1)))
    println(firstMissingPositive(Array(-1,4,2,1,9,10)))
  }
}
