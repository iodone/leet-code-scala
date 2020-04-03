package NQueens

/**
  * Created by iodone on {19-5-22}.
  */

/**
  * 解题报告
  * 
  * 说明：采用递归思路，判断新queen的位置是否安全，坐标的横竖斜都要判断。
  */
object Solution {
  def solveNQueens(n: Int): List[List[String]] = {
    def placeQueens(k: Int): List[List[(Int, Int)]] = {
      if (k == 0) List(List())
      else
        for {
          queens <- placeQueens(k-1)
          c <- 1 to n
          queen = (k, c)
          if isSafe(queen, queens)
        } yield queens ::: queen :: Nil
    }

    def isSafe(queen: (Int, Int), queens: List[(Int, Int)]): Boolean = {
      queens.forall(q => !inCheck(q, queen))
    }

    def inCheck(p: (Int, Int), q: (Int, Int)) = {
      p._1 == q._1 || p._2 == q._2 || (p._1 - q._1).abs == (p._2 - q._2).abs
    }

    def queensToString(allSolution: List[List[(Int, Int)]]) = {
      allSolution.map { queens =>
        queens.map {
         queen =>
           val a = Array.fill(n)('.')
           a(queen._2 - 1) = 'Q'
           a.mkString
        }
      }
    }
    queensToString(placeQueens(n))
  }

}
