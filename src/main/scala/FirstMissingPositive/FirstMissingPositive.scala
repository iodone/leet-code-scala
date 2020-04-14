package FirstMissingPositive

/**
  * Created by iodone on {19-9-12}.
  */

/**
  * 解题报告
  * 
  * 说明：最直接的解法，排序后遍历，复杂度O(nlogn)，不符合题目要求会TLE
  * 
  * 思路：这题是有隐含条件的，最终需要按序寻找 1,2,3,4,..,k，直到不符合递增加1的条件。解决思路类似基数排序
  * （bucket sort），可以把nums[i]安放到应该在的位置nums[nums[i]-1]，通过一次遍历就可以把所有数字安排到位。
  * 注意的是交换后的数字也需要继续安放它到合适的位置，安放条件nums[i]>0 && nums[i]>nums.length &&
  *  nums[i] != nums[nums[i]-1]
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
