package Permutations

/**
  * Created by iodone on {19-5-23}.
  */

object Solution {

  def permute(nums: Array[Int]): List[List[Int]] = {
    if (nums.length <= 0) List(List())
    else
      for {
        head <- nums.toList
        subPer <- permute(nums.filter(_ != head))
        per = head :: subPer
      } yield per
  }
}
