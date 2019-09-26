package SortColors

/**
  * Created by iodone on {19-9-24}.
  */

object Solution {
  def sortColors(nums: Array[Int]): Array[Int] = {
    val colorsNum = nums.foldLeft(Array(0,0,0)) { (acc, x) =>
      acc(x) = acc(x)+1
      acc
    }
    colorsNum.zipWithIndex.flatMap {
      case (x, i) => Array.fill(x)((i, i))
    }.unzip._1
  }

  def main(args: Array[String]): Unit = {
    println(sortColors(Array(0,2,2,2,2,1,0,2,1,0,0,0,1)).toList)
  }
}
