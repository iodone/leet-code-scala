package MinimumPathSum

/**
  * Created by iodone on {19-9-23}.
  */

/**
  * 解题报告
  * 
  * 说明：动态规划
  * 
  * 思路：
  *   定义：grid(i,j)表示经过(i,j)点的代价，dp(i,j)表示从(0,0)到(i,j)的最小代价，由于规则到（i,j)的路径
  *       只能通过（i-1,j)或者（i,j-1)到达
  *   状态转移：dp(i,j) = min(dp(i-1,j)，dp(i,j-1)) + grid(i,j)
  *       dp(i,j) = grid(0,0) (i = 0, j = 0)
  *               = dp(0,j-1)+grid(0,j) (i = 0,  0 < j < grid.columns)
  *               = dp(i-1,0)+grid(i,0) (j = 0, 0 < i < grid.rows)
  *               = min(dp(i-1,j)，dp(i,j-1)) + grid(i,j) ( 0 < i < grid.rows; 0 < j < grid.columns)
  */
object Solution {
  import scala.math.min
  def minPathSum(grid: Array[Array[Int]]): Int = {
    val rows = grid.length
    val columns = grid(0).length
    val dp = Array.fill(rows, columns)(0)

    for (i <- 0 until rows) {
      if (i == 0) dp(0)(0) = grid(0)(0)
      else
        dp(i)(0) = dp(i-1)(0) + grid(i)(0)
    }
    for (j <- 0 until columns) {
      if (j == 0) dp(0)(0) = grid(0)(0)
      else
        dp(0)(j) = dp(0)(j-1) + grid(0)(j)
    }

   for (i <- 1 until rows) {
      for (j <- 1 until columns) {
        dp(i)(j) = min(dp(i-1)(j), dp(i)(j-1)) + grid(i)(j)
      }
    }
    dp(rows-1)(columns-1)
  }

  def main(args: Array[String]): Unit = {
    val grid = Array(Array(1,3,1), Array(1,5,1), Array(4,2,1))
    println(minPathSum(grid))
  }
}
