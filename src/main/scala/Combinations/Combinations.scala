package Combinations

/**
  * 解题报告
  * 
  * 说明：该题类似Combinations Sum，采用深度遍历方式
  * 
  */
object Solution {
    def combine(n: Int, k: Int): List[List[Int]] = {
        comb(n,k,1)
    }

    def comb(n: Int, k: Int, start: Int): List[List[Int]] = {
        if (k == 0) List(List())
        else {
            for {
                i <- (start to n).toList
                x <- comb(n, k-1, i+1) 
            } yield i :: x
        }
    }

    def main(args: Array[String]): Unit = {
        println(combine(4,2))
    }
}