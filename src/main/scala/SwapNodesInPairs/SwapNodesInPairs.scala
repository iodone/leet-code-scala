package SwapNodesInPairs

/**
  * Created by iodone on {19-8-23}.
  */

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {
  def swapPairs(head: ListNode): ListNode = {
    if (head == null || head.next == null) head
    else {
      val p = head.next
      val q = p.next
      head.next.next = head
      head.next = swapPairs(q)
      p
    }
  }

  def printListNode(l: ListNode): Unit = {
    if (l == null) print(".")
    else {
      println(l.x)
      printListNode(l.next)
    }
  }
  def main(args: Array[String]): Unit = {
    val n0 = new ListNode(1)
    val n1 = new ListNode(2)
    val n2 = new ListNode(3)
    val n3 = new ListNode(4)
    n0.next = n1
    n1.next = n2
    n2.next = n3
    printListNode(swapPairs(n0))

  }
}
