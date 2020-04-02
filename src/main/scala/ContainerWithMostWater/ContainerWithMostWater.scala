package ContainerWithMostWater

/**
  * 解题报告
  * 
  * 说明：采用DP思路推导不出状态转移过程
  * 
  * 思路一：BF，总共n(n-1)/2种情况，求最大面积即可
  * 思路二：搜索方式，以heiht[0]-height[n-1]为基准长度最长的容器，逐渐向中间收敛，收敛规则确保向能够
  * 超越当前容量的方向搜索。
  *     
  */

object Solution {

    def maxArea(height: Array[Int]): Int = {
        var curArea = 0
        var (l, r) = (0, height.length-1)
        while(l < r) {
            curArea = curArea max (r - l) * (height(l) min height(r))
            if (height(l) < height(r)) l = l + 1
            else r = r - 1
        }
        curArea
    }

    def main(args: Array[String]) = {
        println(maxArea(Array(1,8,6,2,5,4,8,3,7)))
    }
}