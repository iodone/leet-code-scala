package ValidParentheses

/**
  * Created by iodone on {19-6-4}.
  */

/**
  * 解题报告
  * 说明：按照给定括号序列依次遍历，如果符合匹配规则，消除掉匹配的括号对，不匹配跳过，最后判断剩下括号序列是否为空
  * 实现可以采用List代替堆栈
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

  // 递归思路
   def balance(chars: String): Boolean = {
      def unbalance(rest: String, tag: Int): Int = {
        if (tag == -1 || rest.isEmpty) tag
        else if (rest.head == '(') unbalance(rest.tail, tag + 1)
        else if (rest.head == ')') unbalance(rest.tail, tag - 1)
        else unbalance(rest.tail, tag)
      }
      unbalance(chars, 0) == 0
    }
  

  def main(args: Array[String]): Unit = {
    assert(isValid("[[{[]}]]") == true)
    assert(isValid("[[{[]}}]]") == false)
    assert(isValid("[[") == false)
    assert(isValid("") == true)
  }
}
