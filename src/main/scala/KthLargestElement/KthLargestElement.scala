package KthLargestElement

import scala.collection.mutable

/**
  * Created by iodone on {19-11-1}.
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
