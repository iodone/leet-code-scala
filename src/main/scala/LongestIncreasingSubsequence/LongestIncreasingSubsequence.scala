package LongestIncreasingSubsequence


/**
  * Created by iodone on {19-11-11}.
  */


/**
  * 解题报告
  * 
  * 说明：采用DP思路
  * 
  * 思路
  *   定义：S 表示整个数组，dp(i) 表示以S[i] 结尾的递增子序列长度
  *   状态转移:
  *       dp(i+1) = max { dp(j-1) + if (s[j-1] < s[i]) 1 else 0 (j = 0 to i-1)}
  *   结论：
  *     S的最长递增子序列长度 = max {dp(i) (i = 0 to S.length-1)}
  *   
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
