/**
  * 解题报告
  * 
  * 思路：
  */

trait MyTrie
object Leaf extends MyTrie
case class TrieNode(value: Char, var isEndNode: Boolean) extends MyTrie {
  val children = Array.fill[MyTrie](26)(Leaf)
}

class Trie() {
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

object MyTree {

  def main(args: Array[String]) = {

  }
  
}





/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
