package GroupAnagrams

/**
  * Created by iodone on {19-9-19}.
  */

object Solution {
  def groupAnagrams(strs: Array[String]): List[List[String]] = {
      strs.groupBy(s => s.sorted).values.map(_.toList).toList
  }

  def main(args: Array[String]): Unit = {
    groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat")).foreach(x => println(x.toString()))
  }
}
