package ReverseLinkedList

/**
  * Created by iodone on {19-6-6}.
  */

/**
  * Definition for singly-linked list.
  */

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}
object Solution {

  def reverseList(head: ListNode): ListNode = {

    var newHead: ListNode = head
    var restHead: ListNode = null

    if (head != null && head.next != null) {
      restHead = head.next
      head.next = null
    }

    while (restHead != null) {
      val tmp = restHead
      restHead = tmp.next
      tmp.next = newHead
      newHead = tmp
    }
    newHead
  }

  def reverse(head: ListNode): ListNode = {
    if (head == null || head.next == null) head
    else {
      val q = reverse(head.next)
      head.next.next = head
      head.next = null
      q
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
    val a: ListNode = new ListNode(0)
    var head = a
    for (i <- 1 to 5) {
      head.next = new ListNode(i)
      head = head.next
    }
//    val b = reverseList(a)
    val c = reverse(a)
//    printListNode(b)
    printListNode(c)
  }
}
