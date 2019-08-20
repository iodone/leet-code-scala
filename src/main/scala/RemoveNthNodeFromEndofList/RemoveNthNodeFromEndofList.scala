package RemoveNthNodeFromEndofList

/**
  * Created by iodone on {19-8-20}.
  */
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}
/*
加入哨兵，减少特殊情况判断
 */
object Solution {
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    val initNode = new ListNode()
    initNode.next = head

    var prev = initNode
    var p = head
    var q = head
    var m = n
    while (q != null) {
      if (m <= 0) {
        prev = p
        p = p.next
      }
      q = q.next
      m = m - 1
    }
    prev.next = p.next
    initNode.next
  }

  def printListNode(nl: ListNode): Unit = {
    if (nl == null) println(".")
    else {
      println(nl.x)
      printListNode(nl.next)
    }
  }

  def main(args: Array[String]): Unit = {
    val a = new ListNode(1)
    val b = new ListNode(2)
    val c = new ListNode(3)
    val d = new ListNode(4)
    val e = new ListNode(5)
    a.next = b
    b.next = c
    c.next = d
    d.next = e
    c.next = d
    printListNode(removeNthFromEnd(a, 5))

  }
}
