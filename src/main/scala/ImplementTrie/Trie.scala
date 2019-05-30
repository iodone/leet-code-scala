package ImplementTrie

/**
  * Created by iodone on {19-5-30}.
  */

trait MyTrie
object Leaf extends MyTrie
case class TrieNode(value: Char, var isEndNode: Boolean) extends MyTrie {
  val children = Array.fill[MyTrie](26)(Leaf)
}

class Trie {
  val store = TrieNode('/', false)

  def insert(word: String) {
    var s = store
    for (i <- Range(0, word.length)) {
      val c = word(i)
      s.children(c - 'a') match {
        case Leaf =>
          val newNode = if (i < word.length - 1) TrieNode(c, false) else TrieNode(c, true)
          s.children(c - 'a') = newNode
          s = newNode
        case t: TrieNode => {
          if (i == word.length - 1) t.isEndNode = true
          s = t
        }
      }
    }
  }

  /** Returns if the word is in the trie. */
  def search(word: String): Boolean = {
    var s = store
    word.forall { c =>
      s.children(c - 'a') match {
        case Leaf => false
        case t: TrieNode =>
          s = t
          c == t.value
      }
    } && s.isEndNode
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  def startsWith(prefix: String): Boolean = {
    var s = store
    prefix.forall { c =>
      s.children(c - 'a') match {
        case Leaf => false
        case t: TrieNode =>
          s = t
          c == t.value
      }
    }

  }
}

object solution extends App {
  val trie = new Trie

  trie.insert("apple")
  val a = trie.search("apple") // returns true
  println(a)
  val b = trie.search("app") // returns false
  println(b)
  val c = trie.startsWith("app")
  println(c)
  trie.insert("app")
  val d = trie.search("app")
  println(d)
}
