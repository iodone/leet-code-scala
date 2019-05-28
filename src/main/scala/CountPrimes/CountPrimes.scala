package CountPrimes

/**
  * Created by iodone on {19-5-28}.
  */

object Solution {

  def countPrimes(n: Int): Int = {
//    primes(2 to n toList).length
    primes2(n)
  }

  // stack overflow
  def primes(p: List[Int]): List[Int] = {
    if (p == Nil) p
    else
      p.head :: primes(p.tail.filter(_ % p.head != 0))
  }

  def primes2(n: Int): Int = {
    val a = new Array[Int](n)
    for (i <- 2 until n if a(i) == 0; j <- Array.range(i+i, n, i)) {
      a(j) = 1
    }
    a.drop(2).count(_ == 0)
  }

  def main(args: Array[String]): Unit = {
    assert(countPrimes(2) == 0)
    assert(countPrimes(10) == 4)
    assert(countPrimes(100) == 25)
  }

}
