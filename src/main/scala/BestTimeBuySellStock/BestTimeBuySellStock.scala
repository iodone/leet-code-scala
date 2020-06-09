package BestTimeBuySellStock

/**
  * Created by iodone on {19-10-23}.
  */

/**
  * 解题报告
  * 
  * 说明：动态规划思路，也是滑动窗口的解法
  * 
  * 思路：定义：S表示price序列，dp(i)表示到S[i]为止，当前的最大获利，C[i]代表到S[i]为止的最低点
  *       状态转移 dp(i) = max {dp(i-1), S[i]-C[i]}
  *                C[i] = max {C[i-1], S[i]}
  * 
  * 实现过程中dp(i)和C[i]不用保存前面已经存在的值，因为只需根据前一个值推算出来，所以用两个变量替代即可
  */
object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    if (prices.isEmpty) 0
    else {

      prices.foldLeft((0, prices(0))) { (maxMin, x) =>
        val maxProfit = if (x - maxMin._2 > maxMin._1) {
          x - maxMin._2
        } else maxMin._1
        val minPrice = if (x < maxMin._2) x else maxMin._2
        (maxProfit, minPrice)
      }._1

    }
  }
}
