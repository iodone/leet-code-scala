package MajorityElement

/**
  * Created by iodone on {19-10-31}.
  */


object Solution {
  def majorityElement(nums: Array[Int]): Int = {
    nums.foldLeft((0, 0)) {(acc, x) =>
      if (acc._1 == 0) (1, x) else {
        val sum = if (x != acc._2) acc._1 - 1 else acc._1 + 1
        (sum, acc._2)
      }
    }._2
  }

  def main(args: Array[String]): Unit = {
    println(majorityElement(Array(0,1,1,3,3,3)))
  }
}
