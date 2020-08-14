package CountPrimes

/**
  * Created by iodone on {19-5-28}.
  */

/**
  * 解题报告：
  * 
  * 思路：素数筛选法，假定[2..n]都是素数，从最小素数开始，依次删除其倍数，循环迭代（亦可采用递归方法）
  * 
  * prime([head:tail]) = head :: prime(tail.filter(_ % head != 0))
  */

object Solution {

  def countPrimes(n: Int): Int = {
    //primes(2 to n toList).length
    // primes2(n)
    primes1(Stream.range(2, n)).length
  }

  // stack overflow
  def primes(p: List[Int]): List[Int] = {
    if (p == Nil) p
    else
      p.head :: primes(p.tail.filter(_ % p.head != 0))
  }

  // TLE 
  def primes1(p: Stream[Int]): Stream[Int] = {
    if (p == Nil) p
    else 
     p.head #:: primes1(p.tail.filter(_ % p.head != 0))
  }

  def primes2(n: Int): Int = {
    val a = new Array[Int](n)
    for (i <- 2 until n if a(i) == 0; j <- Array.range(i+i, n, i)) {
      a(j) = 1
    }
    a.drop(2).count(_ == 0)
  }

  def main(args: Array[String]): Unit = {
    println(countPrimes(2))
    println(countPrimes(10))
  }


}
