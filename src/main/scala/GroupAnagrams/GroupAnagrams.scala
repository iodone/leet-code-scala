package GroupAnagrams

/**
  * Created by iodone on {19-9-19}.
  */

/**
  * 解题报告
  * 
  * 思路一：每个单词排序后，groupBy即可
  * 
  * 思路二：对单词进行编码，可以让字符都是一样的单词映射到同一集合，可以采用
  * 计数字符出现次数的编码方式：Array[26]
  */

object Solution {
  def groupAnagrams(strs: Array[String]): List[List[String]] = {
      strs.groupBy(s => s.sorted).values.map(_.toList).toList
  }

  def groupAnagrams1(strs: Array[String]): List[List[String]] = {
    
    val trans = for {
      str <- strs
      codeStr = str.foldLeft(Array.fill(26)(0))((acc, x) => {acc(x - 'a') +=1; acc})
    } yield (codeStr.mkString("#"), str)

    trans.groupBy(_._1).values.map(_.map(_._2).toList).toList

  }

  def main(args: Array[String]): Unit = {
    println(groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat")))
    println(groupAnagrams1(Array("eat", "tea", "tan", "ate", "nat", "bat")))
  }
}
