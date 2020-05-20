package SortColors

/**
  * Created by iodone on {19-9-24}.
  */

/**
  * 解题报告
  * 
  * 思路：基于桶排的思想，按类计算个数，然后从新取出
  */

object Solution {
  def sortColors(nums: Array[Int]): Array[Int] = {
    val colorsNum = nums.foldLeft(Array(0,0,0)) { (acc, x) =>
      acc(x) = acc(x)+1
      acc
    }

    // 小技巧zipWithIndex的使用
    colorsNum.zipWithIndex.flatMap {
      case (x, i) => Array.fill(x)(i)
    }
  }

  def main(args: Array[String]): Unit = {
    println(sortColors(Array(0,2,2,2,2,1,0,2,1,0,0,0,1)).toList)
  }
}
