package KthLargestElement

import scala.collection.mutable

/**
  * Created by iodone on {19-11-1}.
  */

/**
  * 解题报告
  * 
  * 思路1：最小堆实现。取数组前K个元素初始化堆，剩余的数组元素依次和堆顶元素做比较，如果大于堆顶，enqueue后再dequeue。
  * 思路2：类似快排思路
  */

object Solution {

  import scala.collection.mutable.PriorityQueue
  def findKthLargest(nums: Array[Int], k: Int): Int = {
    implicit val myOrd = new scala.Ordering[Int] {
      override def compare(x: Int, y: Int): Int = y - x
    }

    val q = PriorityQueue[Int](nums.slice(0, k): _*)
    val leftNums = nums.slice(k, nums.length)
    for (x <- leftNums) {
      if (x > q.head) {
        q.enqueue(x)
        q.dequeue()
      }
    }
    q.head
  }

  def main(args: Array[String]): Unit = {
    println(findKthLargest(Array(3,2,1,5,6,4), 3))
  }
}
