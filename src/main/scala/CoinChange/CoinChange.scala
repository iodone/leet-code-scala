package CoinChange

/**
  * Created by iodone on {19-11-12}.
  */

object Solution {

  def coinChange(coins: Array[Int], amount: Int): Int = {
    val f = Array.fill(amount+1)(-1)
    f(0) = 0
    for (i <- 1 to amount) {
      var min = Integer.MAX_VALUE
      for (j <- 0 until coins.length) {
        val leftAmount = i - coins(j)
        if (leftAmount >=0) {
          if (f(leftAmount) > -1 && f(leftAmount) < min) min = f(leftAmount) + 1
        }
      }
      if (min < Integer.MAX_VALUE) f(i) = min
    }
    f(amount)
  }

  def main(args: Array[String]): Unit = {
    println(coinChange(Array(1,2,5), 11))
  }
}
