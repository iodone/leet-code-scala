package TwoSum

/**
  *  解题报告
  * 
  *  说明： a + b = c，a 和 b 具有对称的性质，这点可以在实现时利用上
  *
  *  思路一： 总和减去其中一个加数的值在剩下的数组中查找。这里有个小技巧，两个加数具有对称性
  *          第二加数的查找只要基于第一个数的起始位置往后查找即可。时间复杂度: O(n2)
  *  思路二：将数组排序后，查找剩下一个加数。时间复杂度: O(n*log(n))
  *  思路三：用Map保存已经遍历过的加数，直到总和减去加数的值在Map中存在，这里也用到了对称性。时间复杂度：O(n)
  */

object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        var tmp = Map[Int,Int]()
        var snd: (Int, Int) = (-1, -1) 
        
        nums.zipWithIndex.takeWhile { case (x, i) =>
            tmp.get(target - x) match {
                case None => { tmp += (x -> i) ; true }
                case Some(_) => {snd = (x, i); false }
            }
        }
        
        Array(tmp.getOrElse(target-snd._1, -1), snd._2)
    }

    def main(args: Array[String]) = {
        println(twoSum(Array(2, 7, 11, 15), 18).toList)
    }
}