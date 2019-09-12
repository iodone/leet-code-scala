package FindFirstandLastPositionOfElementInSortedArray

/**
  * Created by iodone on {19-9-10}.
  */

object Solution {
  import scala.annotation.tailrec
  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    if (nums.isEmpty) Array(-1, -1)
    else {
      Array(searchLeftRange(nums, 0, nums.length-1, target), searchRightRange(nums, 0, nums.length-1, target))
    }

  }
  @tailrec
  def searchRightRange(xs: Array[Int], left: Int, right: Int, target: Int): Int = {
    val mid = (left + right) / 2
    if (left == right) {
      if (target == xs(left)) left else -1
    } else if (target < xs(mid)) {
      searchRightRange(xs, left, mid-1, target)
    } else if (target > xs(mid)) {
      searchRightRange(xs, mid+1, right, target)
    } else {
      if (mid == xs.length-1 || xs(mid+1) != target) mid
      else searchRightRange(xs, mid+1, right, target)
    }
  }

  @tailrec
  def searchLeftRange(xs: Array[Int], left: Int, right: Int, target: Int): Int = {
    val mid = (left + right) / 2
    if (left == right) {
      if (target == xs(left)) left else -1
    } else if (target < xs(mid)) {
      searchLeftRange(xs, left, mid-1, target)
    } else if (target > xs(mid)) {
      searchLeftRange(xs, mid+1, right, target)
    } else {
      if (mid == 0 || xs(mid-1) != target) mid
      else searchLeftRange(xs, left, mid-1, target)
    }
  }

  def main(args: Array[String]): Unit = {
    val a = Array(4,5,5,5,5,5,5,5,5,5,6,7,0,1,2)
    searchRange(a, 5).foreach(println(_))
  }
}
