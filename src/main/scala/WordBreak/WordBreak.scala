package WordBreak


/**
  * Created by iodone on {19-10-28}.
  */
object Solution {

  // Time Limite execeeded
  def wordBreak1(s: String, wordDict: List[String]): Boolean = {
    if (s.isEmpty) true
    else if (wordDict.isEmpty) false
    else {
      val oks = for {
       w <- wordDict
       ok = s.startsWith(w) && wordBreak1(s.substring(w.length), wordDict)
      } yield ok
      oks.reduce(_ || _)
    }
  }

  // using caching
  import scala.collection.mutable.{HashSet, Map}
  def wordBreak(s: String, wordDict: List[String]): Boolean = {
    val hs = HashSet(wordDict: _*)
    val cache = Map[String, Boolean]()

    def wordBreak0(tail: String): Boolean = {
      if (tail.isEmpty || cache.getOrElse(tail, false)) true
      else {
        var continue = true
        for (i <- 0 until tail.length; if continue) {
          val p = tail.substring(0, i + 1)
          if (wordDict.contains(p) && wordBreak0(tail.substring(p.length))) {
            cache(tail) = true
            continue = false
          }
        }
        if (continue) cache(tail) = false
        cache.getOrElse(tail, false)
      }
    }
    wordBreak0(s)
  }

  // using DP
  // ...

  def main(args: Array[String]): Unit = {
    val x = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
    val xs =  List("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")
    val x0 = "leetcode"
    val xs0 = List("leet", "code")
    val x1 = "catsandog"
    val xs1 = List("cats","dog","sand","and","cat")
    println(wordBreak(x, xs))
    println(wordBreak(x0, xs0))
     println(wordBreak(x1, xs1))
  }
}
