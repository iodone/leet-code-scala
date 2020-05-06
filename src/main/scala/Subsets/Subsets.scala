package Subsets

/**
  * 解题报告
  * 
  * 思路一：深度遍历加回溯,参见 [77.Combinations]。
  *         Comb(S) = [Comb(S, k) | 0 <= k <= S.length]
  *         
  *         Comb(S, k) = [ {S(i) * Comb(S[i+1:], k-1)} | i < S.length]
  * 
  * 思路二：递归思路。包含S(0)的组合和不包含S(0)的组合。
  *         Comb(S) = [{S(0) * Comb(S[1:]} U Comb(S[1:])]
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

  def subsets2(nums: Array[Int]): List[List[Int]] = {
    (0 to nums.length).map(i => comb(nums, 0, i)).flatMap(x => x).toList
  }

  def comb(nums: Array[Int], start: Int, k: Int): List[List[Int]] = {
    if (k == 0) List(List())
    else {
      for {
        i <- (start until nums.length).toList
        x <- comb(nums, i+1, k-1)
      } yield nums(i) :: x
    }
  }

  def main(args: Array[String]): Unit = {
    subsets(Array(1,2,3)).foreach(println(_))
    subsets2(Array(1,2,3)).foreach(println(_))
  }
}

