package RegularExpressionMatching

/**
  * Created by iodone on {19-9-2}.
  */

/*
  采用DB解法
  s 表示input string, p 表示正则匹配式
  dp[i][j]代表s[:i]和p[:j]是否正确匹配，那么有
  if s[i] == p[j] || p[j] == . then dp[i][j] = dp[i-1][j-1]
  else if p[j] == * then
      case 0 匹配: if s[i] != p[j-1] dp[i][j] = dp[i][j-2]
      case 有匹配： if s[i] == p[j-1] || p[j-1] == .
           s 有多个重复(>=2): dp[i][j] = dp[i-1][j]
           s 仅有1个(边界条件)： dp[i][j] = dp[i][j-1]
           s 有0个(边界条件)： dp[i][j] = dp[i][j-2]

 */
object Solution {
  def isMatch(s: String, p: String): Boolean = {

  }
}
