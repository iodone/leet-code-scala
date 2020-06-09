package MajorityElement

/**
  * Created by iodone on {19-10-31}.
  */

/**
  * 解题报告
  * 
  * 说明：二人选举唱票算法，遍历数组，每次取当前值与先前值对比，如果相等，该值数量加1;不相等, 先前值数量减1，如果先前值数量等于0，用当前值替换，且当前值数量设置为1；
  * 由于其中一定有一个值的数量是大于总数二分之一的，那么遍历到最后，一定会有留下数量最多的值
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
