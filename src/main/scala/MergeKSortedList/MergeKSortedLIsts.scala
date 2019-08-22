package MergeKSortedList

/**
  * Created by iodone on {19-8-22}.
  */

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
  }



object Solution {
  import scala.collection.mutable.PriorityQueue
  def mergeKLists(lists: Array[ListNode]): ListNode = {

    implicit val listNodeOrd = new scala.Ordering[ListNode] {
      override def compare(x: ListNode, y: ListNode): Int = y._x - x._x
    }

    val pq = PriorityQueue(lists.filter(_ != null): _*)
    val initListNode = new ListNode()
    var p = initListNode
    while (pq.nonEmpty) {
      p.next = pq.dequeue
      p = p.next
      if (p != null && p.next != null) {
        pq.enqueue(p.next)
      }
    }
    initListNode.next
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

//    printListNode(mergeKLists(Array(n0, m0)))
    printListNode(mergeKLists(Array(null, null)))
  }
}
