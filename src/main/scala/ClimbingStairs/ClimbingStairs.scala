package ClimbingStairs

/**
  * Created by iodone on {19-9-24}.
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
