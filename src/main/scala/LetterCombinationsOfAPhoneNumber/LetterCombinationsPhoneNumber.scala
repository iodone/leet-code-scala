package LetterCombinationsOfAPhoneNumber

/**
  * 解题报告
  * 
  * 说明；模拟即可，打印组合时需要递归
  */

object Solution {

  def composeKey(keys: List[String]): List[String] = {
    if (keys.isEmpty) List()
    else if (keys.length == 1) keys.flatMap(_.toList.map(_.toString))
    else {
      for {
        x <- composeKey(keys.tail)
        y <- keys.head
      } yield y + x
    }
  }

  def letterCombinations(digits: String): List[String] = {
    val numbers = Array("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz") 
    val keys = digits.map(x => { println(x); numbers(x - '0' - 2)})
    composeKey(keys.toList)
  }

  def main(args: Array[String]) = {
    println(letterCombinations("23"))
  }
}