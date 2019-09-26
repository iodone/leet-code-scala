package Subsets

/**
  * Created by iodone on {19-9-26}.
  */
object Solution {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    if (nums.isEmpty) List(List())
    else {
      val sub =  subsets(nums.tail)
      val ret =  for {
        x <- sub
      } yield nums.head :: x
      ret ::: sub
    }
  }

  def main(args: Array[String]): Unit = {
    subsets(Array(1,2,3)).foreach(println(_))
  }
}

