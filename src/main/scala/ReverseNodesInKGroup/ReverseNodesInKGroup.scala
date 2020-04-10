package ReverseNodesInKGroup

/**
  * Created by iodone on {19-8-26}.
  */
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

/**
  * 解题报告
  * 
  * 说明：该问题为swap pair的泛化版本。采用递归思路，第一组的reverse 链接剩下链表的子问题。实现过程中先要
  * 找到第一组的尾结点
  */

object Solution {
  def reverseKGroup(head: ListNode, k: Int): ListNode = {
    if (head == null || head.next == null) head
    else {
      var p = head
      var l = k
      while(l > 1 && p.next != null) {
        p = p.next
        l -= 1
      }
      if (l > 1) {
        head
      } else {
        val q = p.next
        p.next = null
        val r = reverseListNode(head)
        head.next = reverseKGroup(q, k)
        r
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

  def reverseListNode(head: ListNode): ListNode = {
    if (head == null || head.next == null) head
    else {
      val p = reverseListNode(head.next)
      head.next.next = head
      head.next = null
      p
    }
  }

  def main(args: Array[String]): Unit = {
    val n0 = new ListNode(1)
    val n1 = new ListNode(2)
    val n2 = new ListNode(3)
    val n3 = new ListNode(4)
    val n4 = new ListNode(5)
    n0.next = n1
    n1.next = n2
    n2.next = n3
    n3.next = n4
    printListNode(reverseKGroup(n0, 3))
  }
}
