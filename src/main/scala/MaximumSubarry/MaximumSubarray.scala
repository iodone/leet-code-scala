package MaximumSubarry

/**
  * Created by iodone on {19-5-6}.
  */

object Solution {

  import scala.math.max
  def maxSubArray(nums: Array[Int]): Int = {
    val res = nums.foldLeft((0, nums(0))) { (sn, x) =>
      val acc = if (sn._1 < 0) x else sn._1 + x
      (acc, max(acc, sn._2))
    }
    res._2
  }
}
