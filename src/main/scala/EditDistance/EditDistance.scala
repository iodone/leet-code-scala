package EditDistance

/**
  * Created by iodone on {19-9-24}.
  */

/*
  define: a, b word string, dp[i][j] = a[:i] and b[:j] edit distance
  dp[i][j] = {
     if a[i] == b[i] then dp[i-1][j-1]
     else
      min {
        case delete b[j] or insert b[j]: dp[i][j-1] + 1
        case delete a[i] or insert a[i]: dp[i-1][j] + 1
        case replace a[i] or b[j] to equal: dp[i-1][j-1] + 1
      }
  }

  dp[i][0] = i
  dp[0][j] = j

 */

object Solution {
  import scala.math.min
  def minDistance(word1: String, word2: String): Int = {
    val dp = Array.fill(word1.length+1, word2.length+1)(0)
    for (i <- 1 to word1.length)
      dp(i)(0) = i
    for (j <- 1 to word2.length)
      dp(0)(j) = j

    for (i <- 1 to word1.length)
      for (j <- 1 to word2.length) {
        if (word1(i-1) == word2(j-1)) dp(i)(j) = dp(i-1)(j-1)
        else dp(i)(j) = min(min(dp(i)(j-1), dp(i-1)(j)), dp(i-1)(j-1)) +1
      }

    dp.foreach(xs => println(xs.toList))
    dp.last.last
  }

  def main(args: Array[String]): Unit = {
    println(minDistance("horse", "ros"))
    println(minDistance("intention", "execution"))
  }
}
