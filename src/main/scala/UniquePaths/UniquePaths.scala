package UniquePaths

/**
  * Created by iodone on {19-9-23}.
  */

/**
  * 解题报告
  * 
  * 说明：经典的动态规划解决方案
  * 
  * 思路：
  *   定义：dp(i,j) 代表从(0,0) 到 (i,j) 路径总数
  *   状态转移：dp(i,j) = dp(i-1,j)+dp(i,j-1)
  *   初始边界条件：dp(0, j) = 1 (0 <= j < m); dp(i, 0) = 1 (0 <= i < n)
  */
object Solution {
  def uniquePaths(m: Int, n: Int): Int = {
      if (m <= 0 || n <= 0) 0
      val dp = Array.fill(n, m)(0)
      dp(0) = Array.fill(m)(1)
      for (i <- 0 until n) {
        dp(i)(0) = 1
      }

      for (i <- 1 until n) {
        for (j <- 1 until m) {
          dp(i)(j) = dp(i-1)(j) + dp(i)(j-1)
        }
      }
      dp(n-1)(m-1)
  }

  def main(args: Array[String]): Unit = {
    println(uniquePaths(0, 1))
  }
}
