package MergeIntervals

/**
  * Created by iodone on {19-9-20}.
  */

/**
  * 解题报告
  * 
  * 思路：先按第一个元素排序，假设第1,2个interval分别为[a, b]，[c,d]
  * 有交集，存在两种情况：[a, c, b, d] 或者 [a, b, d, c];
  * 没有交集，[a,b], [c,d](c > b),由于排序过，不相交的也具备传递性，
  * 如果前两个不相交（c > b），那么第三个[e,f] 也不会相交，因为（e >= c > b）
  */

object Solution {
  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
      intervals.sortBy(xs => xs(0)).foldLeft(Array[Array[Int]]()) { (acc, xs) =>
        if (acc.isEmpty) acc :+ xs
        else {
          if (xs(0) > acc.last(1)) {
            acc :+ xs
          } else {
            if (acc.last(1) < xs(1)) acc(acc.length-1) = Array(acc.last(0), xs(1))
            acc
          }
        }
      }
  }

  def main(args: Array[String]): Unit = {
    val xss = Array(Array(1,3),Array(2,6),Array(8,10),Array(15,18))
    merge(xss).foreach(xs => println(xs.toList))
  }
}
