package CoinChange2

/**
  * 解题报告
  * 
  * 说明: 爬楼梯(70)的升级版，相当于可以一次爬的选择有多种。但是爬楼梯是有顺序的，该题换硬币
  *     是没有顺序的，会去除重复的组合数
  * 
  * 思路一：递归方法。由于选择是变化的，通过数组传进来，不可能枚举像这样的f(n)=f(i)+f(j)+f(k)+...。
  *       换另一种思路，拆解成两个子问题，要么选择第一种硬币，要么不选，递推表达式：
  *        f(n, S) = f(n-S(0), S) + f(n, S[1:])，但是TL
  * 
  * 思路二：动态规划（带顺序的，不符合题意）
  *         dp(n) = sum{dp(n-S(i)) | i < S.length}
  * 
  * 思路三：动态规划, dp(k, i)表示amount是n和前i个硬币的种数
  *     dp(k, i) = { dp(k, i-1) + dp(k-s(i), i)| i < S.length, 1 <= k <= n}
  *     
  *     参考；https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/bei-bao-ling-qian
  */

object Solution {
    def change(amount: Int, coins: Array[Int]): Int = {
        if (amount == 0) 1
        else if (amount < 0 || coins.isEmpty) 0
        else {
            change(amount-coins.head, coins) + change(amount, coins.tail)
        }
    }

    // 不符题意，适合爬楼梯的解法
    def change2(amount: Int, coins: Array[Int]) = {
        val dp = Array.fill(amount+1)(0)
        dp(0) = 1
        for (i <- 1 to amount) {
            for (j <- 0 until coins.length) {
                if (i - coins(j) >= 0)   
                    dp(i) += dp(i-coins(j))
            }
        }
        dp(amount)
    }

    // 优化状态空间的结果，符合题意，与change2比较消除了顺序性
    def change3(amount: Int, coins: Array[Int]) = {
        val dp = Array.fill(amount+1)(0)
        dp(0) = 1
        for (i <- 0 until coins.length) {
            for (j <- 1 to amount) {
               if (j - coins(i) >= 0)
                dp(j) += dp(j-coins(i))
            }
        } 
        dp(amount)
    }


    def main(args: Array[String]) = {
        println(change(5, Array(1,2,5)))
        println(change2(5, Array(1,2,5)))
        println(change3(5, Array(1,2,5)))
        println(change(3, Array(2)))
        println(change2(3, Array(2)))
        println(change3(3, Array(2)))
    }
}