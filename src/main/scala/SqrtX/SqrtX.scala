package SqrtX

/**
  * Created by iodone on {19-8-15}.
  */
/**
  * 解题报告
  * 
  * 说明：逐个枚举即可
  * 
  * 思路：通用开平方的解法，采用递归思路，利用牛顿迭代法（夹逼法）逐步靠近
  */
object Solution {
  import scala.math.{floor, abs}
  def mySqrt(x: Int): Int = {
    if (x == 0) 0
    else (1 to x/2 + 1).takeWhile(f => f <= x/f).last
  }

  def sqrtIter(x: Int, guess: Double): Double = {
    if (abs(guess*guess - x) < 0.1) guess
    else {
      val improvedGuess = (x.toDouble / guess + guess) / 2
      sqrtIter(x, improvedGuess)
    }
  }

  def main(args: Array[String]): Unit = {
    val a = sqrtIter(100, 1)
    println(mySqrt(10))
    println(a)
  }

}
