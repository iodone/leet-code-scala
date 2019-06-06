package ValidParentheses

/**
  * Created by iodone on {19-6-4}.
  */

object Solution {


  def isPair(a: Char, b: Char) = {
    a + b == '[' + ']' || a + b == '{' + '}' || a + b == '(' + ')'
  }

  def isValid(s: String): Boolean = {

    val xs = s.foldLeft("") {
      (acc, x) =>
        if (!acc.isEmpty && isPair(acc.head, x)) {
          acc.tail
        } else x + acc
    }
    xs.isEmpty
  }

  def main(args: Array[String]): Unit = {
    assert(isValid("[[{[]}]]") == true)
    assert(isValid("[[{[]}}]]") == false)
    assert(isValid("[[") == false)
    assert(isValid("") == true)
  }
}
