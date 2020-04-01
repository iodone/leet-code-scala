package LongestSubStringWithoutRepeatingCharacters

/**
  * 解题报告
  * 
  * 说明：动态规划，这题和最大连续子串和的状态转移方程类似
  * 
  * 思路
  *     1.定义：
  *     S 表示整个字符串, S[i] 第i个字符，C(i) 以 S[i] 结尾的不重复字符串，dp(i) 表示字符串 S[0..i]的最大不重复
  *     子串长度 。
  *     2.转移方程：
  *        dp(i+1) = max {dp(i), length(C(i+1))}，这里
  *        C(i+1) =  C(i)+S[i+1] if S[i+1] not in C(i)
  *               | S[j+1..i+1] if S[j] in C(i) and S[j] == S[i+1]
  *               
  *     
  * 
  */

object Solution {

    def lengthOfLongestSubstring(s: String): Int = {

      s.foldLeft((0, "")) {(acc, x) =>
        val index = acc._2.indexOfSlice(x.toString)
        val tmp = acc._2.substring(index + 1) + x
        (acc._1 max tmp.length(), tmp)
      }._1

    }

    def main(args: Array[String]) ={
      println(lengthOfLongestSubstring("abcabcbb"))
      println(lengthOfLongestSubstring("pwwkew"))
    }
}