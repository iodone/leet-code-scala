package SearchInRotatedSortedArray

/**
  * Created by iodone on {19-9-9}.
  */

object Solution {
  def search(nums: Array[Int], target: Int): Int = {
    if (nums.isEmpty) -1
    else binarySearchInRotate(nums, 0, nums.length-1, target)
  }

  def binarySearchInRotate(xs: Array[Int], left: Int, right: Int, target: Int): Int  = {
    if (left == right) {
      if (xs(left) == target) left else -1
    } else {
      val mid = (left + right) / 2
      if (xs(mid) == target) mid
      else {
        if (xs(left) <= xs(mid)) {
          if (target < xs(mid) && target >= xs(left)) binarySearchInRotate(xs, left, mid-1, target)
          else binarySearchInRotate(xs, mid+1, right, target)
        } else {
          if (target > xs(mid) && target <= xs(right) ) binarySearchInRotate(xs, mid+1, right, target)
          else binarySearchInRotate(xs, left, mid-1, target)
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val a = Array(4,5,6,7,0,1,2)
    println(search(a, 5))
  }
}
