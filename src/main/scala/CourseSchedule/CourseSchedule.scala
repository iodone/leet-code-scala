package CourseSchedule


/**
  * 解题报告
  * 
  * 说明：属于图中环的判断，图的表达形式一般有Edge List，Adjacency matrices，Adjacency lists。此题属于Edge List的表现形式。参见：https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/representing-graphs
  * 
  * 思路：DFS搜索，记录访问路径，如果图中有环，一定会遍历到已经访问过的节点。根据节点边可以找到下一次的搜索节点，一直递归进行，直到有已经访问过的节点再次被访问退出。
  *     依次从每个节点发起搜索，就可以找出所有图中是否有环的情况。
  */
object Solution {

    def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
        var ret = true
        (0 until numCourses).takeWhile { x => ret = isCircle(x, Map[Int, Boolean](), prerequisites); ret}
        ret
    }

    def isCircle(node: Int, visited: Map[Int, Boolean], prerequisites: Array[Array[Int]]): Boolean = {
        if (visited.contains(node)) false
        else {
            var tag = true
            for (nextNode <- prerequisites.filter(_(0) == node)) {
                // prune
                if (tag == true) {
                    tag = isCircle(nextNode(1), visited + (node -> true), prerequisites)
                }
            }
            tag
        }
    }

    def main(args: Array[String]) = {
        println(canFinish(2, Array(Array(0,1), Array(1,0))))
        println(canFinish(4, Array(Array(2,0), Array(1,0), Array(3,1), Array(3,2), Array(1,3))))
        println(canFinish(4, Array(Array(1,0), Array(1,3), Array(2,0), Array(3,1), Array(3,2))))
    }

}