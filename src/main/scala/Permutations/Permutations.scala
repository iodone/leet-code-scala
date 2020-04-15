package Permutations

/**
  * Created by iodone on {19-5-23}.
  */

/**
  * 解题报告
  * 
  * 说明:采用递归和深度搜索策略
  * 
  * 思路一：递归思路，Perm(S) = {S(i) U Perm(S.remove(i)) | i < length}
  * 
  * 思路二：深度搜索，每个数组成员为搜索路径与递归思路一致
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
