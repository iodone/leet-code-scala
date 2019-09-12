package CombinationSum

import scala.collection.mutable.ArrayBuffer

/**
  * Created by iodone on {19-9-11}.
  */
// 回溯
object Solution {

  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    comb(candidates, 0, target)
  }

  // prune
  /*
     candidates = C,
     comb(s) = { {Ci} U comb(s-Ci)| i < C.length}
   */
  def comb(xs: Array[Int], start: Int, left: Int): List[List[Int]] = {
    if (left == 0) List(List())
    else if (left < 0) List(List(-1))
    else {
      for {
        i <- (start until xs.length).toList
        cs <- comb(xs, i, left - xs(i))
        if cs != List(-1)
      } yield xs(i) :: cs
    }
  }

  // dfs + 回溯
  def genComb(candidates: Array[Int], target: Int): Unit = {
    val buf = ArrayBuffer[List[Int]]()
    def dfs(start: Int, left: Int, tmp: List[Int]): Unit = {
      if (left == 0) buf += tmp
      else {
        for (i <- start until candidates.length) {
          if (left - candidates(i) >= 0)
            dfs(i, left - candidates(i), tmp ::: candidates(i) :: Nil)
          tmp.dropRight(1)
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val x = combinationSum(Array(2,3,6,7), 7)
    x.foreach(println(_))
  }

}
