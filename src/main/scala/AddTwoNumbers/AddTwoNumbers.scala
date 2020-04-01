package AddTwoNumbers

/**
  * Created by iodone on {19-8-16}.
  */
/**
  * Definition for singly-linked list.
  * class ListNode(var _x: Int = 0) {
  *   var next: ListNode = null
  *   var x: Int = _x
  * }
  */
class ListNode(var _x: Int = 0) {
      var next: ListNode = null
      var x: Int = _x
}

/**
  *  解题报告
  * 
  *  说明：涉及到链表边界问题可以尝试设置 guard 来去除特殊条件判断，减少代码冗余
  * 
  *  思路一：两个链表同时遍历，直到长链表全部遍历完成，短链表用 0 补足。注意 carry 的处理，最后要判断进位
  *  思路二：递归思路。转换为两个链表头结点相加的新节点链接到 剩下两个链表的合并生成的新链表（子问题）。由于carry要传递
  *         设计递归函数时，需要加上 carry 参数。
  */

object Solution {


  def addTwoNumbers1(l1: ListNode, l2: ListNode, carry: Int = 0): ListNode = {

    val lv1 = if (l1 != null) l1.x else 0
    val lv2 = if (l2 != null) l2.x else 0
    val sum = (lv1 + lv2 + carry) % 10
    val carryChange = if (lv1 + lv2 + carry >= 10) 1 else 0
    val addList = new ListNode(sum)
    if (l1 == null && l2 == null && sum == 0) null
    else if (l1 == null && l2 == null && sum > 0) addList
    else {
      val lnext1 = if (l1 != null) l1.next else l1
      val lnext2 = if (l2 != null) l2.next else l2
      addList.next = addTwoNumbers1(lnext1, lnext2, carryChange)
      addList
    }
  }

  /*
  合理设置guard来解决边界问题
  * */
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var p = l1
    var q = l2
    var carry = 0
    val newList = new ListNode
    var n = newList
    while(p != null || q != null) {
      val fst = if (p != null) {val v = p.x; p = p.next; v} else 0
      val snd = if (q != null) {val v = q.x; q = q.next; v} else 0

      n.next = new ListNode
      val sum = fst + snd
      if (sum + carry >= 10) {
          n.next.x = sum + carry - 10
          carry = 1
      } else {
        n.next.x = sum + carry
        carry = 0
      }
      n = n.next
    }
    if (carry == 1) {
      n.next = new ListNode(1)
    }
    newList.next
  }
  def printListNode(l: ListNode): Unit = {
    if (l == null) print(".")
    else {
      println(l.x)
      printListNode(l.next)
    }
  }
  def main(args: Array[String]): Unit = {
    val n0 = new ListNode(9)
    val n1 = new ListNode(9)
    n0.next = n1
    val m0 = new ListNode(9)
    val m1 = new ListNode(9)
    val m2 = new ListNode(9)
    m0.next = m1
    m1.next = m2
    printListNode(addTwoNumbers1(n0, m0, 0))

  }
}
