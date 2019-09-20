package MergeIntervals

/**
  * Created by iodone on {19-9-20}.
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
