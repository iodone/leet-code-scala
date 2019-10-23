package BestTimeBuySellStock

/**
  * Created by iodone on {19-10-23}.
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
