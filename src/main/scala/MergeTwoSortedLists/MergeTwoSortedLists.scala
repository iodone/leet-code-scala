package MergeTwoSortedLists

/**
  * Created by iodone on {19-9-6}.
  */

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {
  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    if (l1 == null && l2 == null) null
    else if (l1 == null) l2
    else if (l2 == null) l1
    else {
      val next = if (l1.x <= l2.x) {
        (l1, l1.next, l2)
      } else {
        (l2, l1, l2.next)
      }
      next._1.next = mergeTwoLists(next._2, next._3)
      next._1
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
    val n1 = new ListNode(5)
    n0.next = n1
    val m0 = new ListNode(2)
    val m1 = new ListNode(4)
    val m2 = new ListNode(9)
    m0.next = m1
    m1.next = m2
    printListNode(mergeTwoLists(n0, m0))
  }
}
