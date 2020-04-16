package ClimbingStairs

/**
  * Created by iodone on {19-9-24}.
  */
/**
  * 解题报告
  * 
  * 说明：递归问题，也可以转化为动态规划实现
  * 
  * 状态转移：dp(n) = dp(n-1)+dp(n-2)
  */
object Solution {
  def climbStairs(n: Int): Int = {
    if (n <= 1) 1
    else if (n == 2) 2
    else climbStairs(n-1) + climbStairs(n-2)
  }

  def main(args: Array[String]): Unit = {
    println(climbStairs(5))
  }
}
