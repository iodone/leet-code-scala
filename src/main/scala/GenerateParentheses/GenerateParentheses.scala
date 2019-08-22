package GenerateParentheses

/**
  * Created by iodone on {19-8-21}.
  */

object Solution {
  /*
   TODO: Using val to improve it
   */
  import scala.collection.mutable.ArrayBuffer
  def generateParenthesis(n: Int): List[String] = {
    val arrayBuffer = ArrayBuffer[String]()

    def dfs(left: Int, right: Int, tmp: String): Unit = {
      if (left == 0 && right == 0) arrayBuffer += tmp
      else {
        if (left > 0) {
          dfs(left - 1, right, tmp + "(")
        }
        if (left < right) {
          dfs(left, right - 1, tmp + ")")
        }
      }
    }

    dfs(n, n, "")
    arrayBuffer.toList

  }

  /*

   */
  import scala.collection.mutable.SortedSet
  def generateParenthesis0(n: Int): List[String] = {
    if (n == 0) List()
    else if (n == 1) List("()")
    else {
      val tmp = SortedSet[String]()
      for {
        s <- generateParenthesis0(n - 1)
      } {
        tmp += "()" + s
        tmp += s + "()"
        tmp += "(" + s + ")"
      }
      tmp.toList
    }
  }

  def main(args: Array[String]): Unit = {
    println(generateParenthesis(2))
  }

}
