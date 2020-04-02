package ReverseInteger

/**
  *  解题报告
  *   
  *  说明： 注意有些数字逆序后会超过 Int32.Max，需要提前判断
  */

object Solution {
  def reverse(x: Int): Int = {
    var p = BigInt(x) 
    var r = BigInt(0)

    while (p != 0) {
      val tmp = p % 10            
      p = p / 10
      r = r * 10 + tmp
      if (r > Int.MaxValue || r < Int.MinValue) {p = 0; r = 0}
    }
    r.toInt
  }

  def main(args: Array[String]) = {
    println(reverse(-123457))
    println(reverse(123457))
    println(reverse(1534236469))
  }
}