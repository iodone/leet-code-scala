package LongestIncreasingSubsequence


/**
  * Created by iodone on {19-11-11}.
  */

/*
  Solve with DP
  dp[i] is length of longest increasing equence with nums[i] end
  dp[i] = max {
    dp[i-1] + 1 if (nums[i] < nums[i-1]) (i = 0 to i-1)
    1
  }
 */

object Solution {
  def lengthOfLIS(nums: Array[Int]): Int = {
    if (nums.isEmpty) 0
    else {
      val dp = Array.fill(nums.length)(0)
      dp(0) = 1
      for (i <- 1 until nums.length) {
        var max = 1
        for (j <- 0 until i) {
          if (nums(j) < nums(i)) {
            if (dp(j) + 1 > max) max = dp(j) + 1
          }
        }
        dp(i) = max
      }
      dp.max
    }
  }

  def main(args: Array[String]): Unit = {
    println(lengthOfLIS(Array(10,9,2,5,3,7,101,18)))
  }
}
