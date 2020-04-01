package MaximumSubarry

/**
  * Created by iodone on {19-5-6}.
  */

/**
  * 解题报告
  * 
  * 说明：采用DP思路，状态转移类似最长不重复字符串
  * 
  * 思路
  *   定义：S 表示数组，C(i) 表示以S[i]结尾的连续数组和
  *   状态转移：
  *       dp(i) = max {dp(i-1), C(i)} 这里
  *       C(i) = S[i] if C(i-1) < 0
  *              S[i] + C(i-1) if C(i-1) >= 0
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
