package RemoveNthNodeFromEndofList

/**
  * Created by iodone on {19-8-20}.
  */
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

/**
  * 解题报告
  * 
  * 思路：
  *   1.链表移除需要保存前一个节点，避免断链。如果remove的是head节点，需要特殊情况判断，为了避免特殊情况，
  * 增加 guard 来消除特殊逻辑判断。
  *   2.remove 倒数n个节点，首先要找到该节点，可以采用双指针方法，先让快指针走n步，然后同步速率，直到
  *   快指针到达链表尾部
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
