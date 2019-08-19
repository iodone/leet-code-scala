package LongestPalindromicSubstring

/**
  * Created by iodone on {19-8-19}.
  */

object Solution {
  /*
    如果P(i,j) 表示Si..Sj的回文字串，那么有以下几种情况的推导
    P(i,j) = P(i+1, j-1) where i + 1 < j, Si == Sj
    P(i,j) = P(i,j) where i + 1 == j, Si == Sj
    P(i,j) = P(i,j) where i == j
   */
  def longestPalindrome(s: String): String = {

    //
    //      val palindromeTag = Array.range(0, s.length).map { x =>
    //        new Array[Int](s.length)
    //      }
    //      val palindromeTag0 = Array.ofDim[Int](s.length, s.length)

    val palindromeTag = Array.fill(s.length, s.length)(0)
    var max = (0, 0)
    for (l <- 1 to s.length; i <- 0 to s.length - l) {
      val j = i + l - 1
      if (i == j) {
        palindromeTag(i)(j) = 1
      }
      if (i + 1 == j && s(i) == s(j)) {
        palindromeTag(i)(j) = 2
      }
      if (i + 1 < j && palindromeTag(i+1)(j-1) > 0 && s(i) == s(j)) {
        palindromeTag(i)(j) = palindromeTag(i+1)(j-1) + 2
      }
      max = if (max._2 < palindromeTag(i)(j)) (i, palindromeTag(i)(j)) else max
    }
    s.slice(max._1, max._1 + max._2)
  }

  def main(args: Array[String]): Unit = {
    println(longestPalindrome("cabbaa"))
    println(longestPalindrome("babad"))
    println(longestPalindrome("abcba"))
  }
}