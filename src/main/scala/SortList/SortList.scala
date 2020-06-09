package SortList

/**
  * Created by iodone on {19-10-29}.
  */

/**
  * 解题报告
  * 
  * 思路：快排，分解为左右两个排好序的链表与piovt结点连接即可。由于左链表只返回了头结点，连接时必须找到尾结点。
  *
  */

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {
  def sortList(head: ListNode): ListNode = {
    if (head == null) null
    else {
      var p = head.next
      val leftHead = new ListNode(0)
      var leftP = leftHead
      val rightHead = new ListNode(0)
      var rightP = rightHead
      while (p != null) {
        if (p.x < head.x) {
          leftP.next = p
          leftP = leftP.next
          p = p.next
          leftP.next = null
        } else {
          rightP.next = p
          rightP = rightP.next
          p = p.next
          rightP.next = null
        }
      }
      val newHead = sortList(leftHead.next)
      var pNewTail = newHead
      if (pNewTail != null) {
        while(pNewTail.next != null) {
          pNewTail = pNewTail.next
        }
      }

      if (pNewTail == null) {
        head.next = sortList(rightHead.next)
        head
      } else {
        pNewTail.next = head
        head.next = sortList(rightHead.next)
        newHead
      }
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
    val n0 = new ListNode(3)
    val n1 = new ListNode(2)
    val n2 = new ListNode(4)
    val n3 = new ListNode(1)
    val n4 = new ListNode(5)
    n0.next = n1
    n1.next = n2
    n2.next = n3
    n3.next = n4
    printListNode(sortList(n0))
  }
}
