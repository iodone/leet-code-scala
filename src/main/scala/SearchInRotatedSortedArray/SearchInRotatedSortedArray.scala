package SearchInRotatedSortedArray

/**
  * Created by iodone on {19-9-9}.
  */

/**
  * 解题报告
  * 
  * 说明；虽然是环形有序数组，但是仍然能够利用二分查找的思想。
  * 
  * 思路：每次从中间将数组分成左右两部分后，可以发现总有一部分是有序的，根据每部分边界值xs.head <= xs.last
  * 判断是否有序，每次只要在有序部分寻找目标值即可，如果存在则继续进行二分查找（有序部分），
  * 不存在则在另一部分（无序部分）继续按以上步骤查找，直到结束。
  * 每次都能将搜寻空间缩小到二分之一,所以最终时间复杂度是 O(logn)
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
