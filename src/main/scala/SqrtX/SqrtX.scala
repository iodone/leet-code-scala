package SqrtX

/**
  * Created by iodone on {19-8-15}.
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
