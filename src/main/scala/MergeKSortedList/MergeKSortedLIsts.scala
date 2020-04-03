package MergeKSortedList

/**
  * Created by iodone on {19-8-22}.
  */

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
  }

/**
  * 解题报告
  * 
  * 思路：
  *   1.初始化。采用最小堆存储n个队列的头节点，由于是排序过的，最小值肯定在堆中。
  *   2. 增加后继节点。出堆，堆顶为当前最小节点，保存。同时将该节点的对应队列的后续节点放入堆中。
  *   3. 循环 步骤2直到堆为空。因为每次从堆顶的节点对应的队列中的后继节点是有序的，所以可以保证有序性
  * 
  */


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
