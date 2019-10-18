package BinaryTreeLevelOrderTraversal

/**
  * Created by iodone on {19-10-18}.
  */

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def levelOrder(root: TreeNode): List[List[Int]] = {
    if (root == null) List()
    else {
      var leftQ = List(List(root))
      var levelOrderList: List[List[Int]] = List()
      while (leftQ.nonEmpty && leftQ.head != List()) {
        levelOrderList = levelOrderList ::: leftQ.head.map(_.value) :: Nil
        leftQ = leftQ.tail ::: leftQ.head.flatMap { n =>
           List(n.left, n.right).filter(_ != null)
        } :: Nil
      }
      levelOrderList
    }
  }

  def levelOrder2(root: TreeNode): List[List[Int]] = {
    if (root == null) List()
    else {
      List(root.value) :: levelOrder2(root.left).zipAll(levelOrder2(root.right), List(), List()).map(f => f._1 ::: f._2)
    }
  }

  def main(args: Array[String]): Unit = {
    val node0 = new TreeNode(5)
    val node1 = new TreeNode(4)
    val node2 = new TreeNode(7)
    node0.left = node1
    node0.right = node2
    println(levelOrder2(node0))
  }

}
