package MaximunProductSubarray

/**
  * Created by iodone on {19-10-30}.
  */

object Solution {
  import scala.math.{max, min}
  def maxProduct(nums: Array[Int]): Int = {
      nums.foldLeft((1, 1, nums(0))) { (sn, x) =>
        val (accPos, accNeg, tmpMax) = if (x == 0) (1, 1, 0) else {
          val tmp0 = sn._1 * x
          val tmp1 = sn._2 * x
          if (tmp0 > 0) (tmp0, tmp1, tmp0) else {
            if (tmp1 < 0) (1, tmp0, tmp0)
            else (tmp1, tmp0, tmp1)
          }
        }
        (accPos, accNeg, max(sn._3, tmpMax))
      }._3
  }

  def main(args: Array[String]): Unit = {
    println(maxProduct(Array(-1,2,3,4,-5,5,7,-10)))
    println(maxProduct(Array(2,3,4,-5,5, 7, 8,-10)))
  }
}
