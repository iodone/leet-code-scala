package CombinationSum

import scala.collection.mutable.ArrayBuffer

/**
  * Created by iodone on {19-9-11}.
  */

/**
  * 解题报告
  * 
  * 说明：采用深度搜索和递归的方法, coinchange2(518)的全路径打印
  * 
  * 思路一：深度搜索遍历候选数组每个成员，都可以作为一个搜索入口。为避免重复，剪枝策略：每个分支仅
  * 搜索包含自身的后续成员。如果最后剩下的target < 0 表明该分支不符合。
  * Comb(S, target) = [ {S(i) * Comb(S[i+1:], target - S(i))}| i < S.length]
  * 实现方式可以采用：完全递归和dfs的遍历两种
  * 
  * 思路二：递归方法。该问题可以拆解成两部分：包含第一个成员和不包含第一个成员的组合数。
  * Comb(S,target) = [ {S(0) * Comb(S, target-S(0))} U Comb(S[1:], target)]
  * 这个方式实现更适合计算组合数。也就是CoinChange2的解法。
  * 
  * 回溯算法套路：
  * 
  * 参考：https://github.com/labuladong/fucking-algorithm/blob/master/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/%E5%9B%9E%E6%BA%AF%E7%AE%97%E6%B3%95%E8%AF%A6%E8%A7%A3%E4%BF%AE%E8%AE%A2%E7%89%88.md
  * 
  * val result = ArrayBuffer()
  * def backtrace(path, candiateList): Unit = {
  * 
  *   if 条件满足 result += path
  *   else 
  *     for selected in candidateList
  * 
  *       // 筛选减枝,这里是传入的是path常量，后面不用再撤销
  *       backtrace(path.add(selected), candidtateList)
  * 
  */
object Solution {

  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    // comb(candidates, 0, target)
    genComb(candidates, target)
  }

  // prune
  /*
     candidates = C,
     comb(s) = { {Ci} U comb(s-Ci)| i < C.length}
   */
  def comb(xs: Array[Int], start: Int, left: Int): List[List[Int]] = {
    if (left == 0) List(List())
    else if (left < 0) List(List(-1))
    else {
      for {
        i <- (start until xs.length).toList
        cs <- comb(xs, i, left - xs(i))
        if cs != List(-1)
      } yield xs(i) :: cs
    }
  }

  // dfs + 回溯
  def genComb(candidates: Array[Int], target: Int): List[List[Int]] = {
    val buf = ArrayBuffer[List[Int]]()
    def dfs(start: Int, left: Int, tmp: List[Int]): Unit = {
      if (left == 0) buf += tmp
      else if (left < 0) return
      else {
        for (i <- start until candidates.length) {
          dfs(i, left - candidates(i), tmp ::: candidates(i) :: Nil)
        }
      }
    }
    dfs(0, target, List())
    buf.toList
  }

  def main(args: Array[String]): Unit = {
    val x = combinationSum(Array(2,3,6,7), 7)
    println(x)
  }

}
