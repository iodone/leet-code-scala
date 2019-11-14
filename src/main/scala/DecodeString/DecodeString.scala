package DecodeString

/**
  * Created by iodone on {19-11-14}.
  */

object Solution {
  def decodeString(s: String): String = {
    if (s == "") ""
    else if (s.head >= 'A' && s.head <= 'z') s.head +: decodeString(s.tail)
    else {
      val xs = s.split('[')
      val replicate = xs.head.toInt
      val left = xs.tail.mkString("[")
      val (body, tail) = splitString(left)
      (decodeString(body) * replicate) ++ decodeString(tail)
    }
  }

  // input string like this: aaa2[b]cc]
  def splitString(s: String): (String, String) = {
    var sum = 1
    var splitPoinit = 0
    for (i <- 0 until s.length) {
      if (sum > 0) {
        if (s(i) == ']') {
          sum -= 1
          if (sum == 0) splitPoinit = i
        }
        else if (s(i) == '[') sum += 1
      }
    }
    (s.substring(0, splitPoinit), s.substring(splitPoinit+1))
  }

  def main(args: Array[String]): Unit = {
    println(splitString("aaa2[b]cc]ddd"))
    println(decodeString("3[a]2[bc]"))
    println(decodeString("3[a2[c]]"))
    println(decodeString("2[abc]3[cd]ef"))
  }
}
