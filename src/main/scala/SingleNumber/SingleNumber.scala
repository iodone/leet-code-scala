package SingleNumber

/**
  * Created by iodone on {19-10-28}.
  */

/**
  *  解题报告
  * 
  *  说明：采用异或全部列表
  */

object Solution {
  def singleNumber(nums: Array[Int]): Int = {
    nums.reduceLeft((acc, x) => acc ^ x)
  }

  def main(args: Array[String]): Unit = {
    println(singleNumber(Array(1,2,2,4,4,5,5)))
  }
}
