package ValidateBinarySearchTree

/**
  * Created by iodone on {19-10-16}.
  */

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}


/**
  * 解题报告
  * 
  * 思路：BST的判断不是与构建的时候那么明显，特别需要注意每个节点是有上界和下界的。在处理left节点容易忽略上界，right节点容易忽略下界。
  *     采用递归思路。通过min和max保存当前节点的上下界，同时进入到左子树时更新上界，进入到右子树更新下界。
  * 
  */
object Solution {
  def isValidBST(root: TreeNode): Boolean = {
//    inorderTraversal(root)._2
    isValid(root, BigInt(Int.MinValue)-1, BigInt(Int.MaxValue)+1)
  }


  def inorderTraversal(root: TreeNode): (List[Int], Boolean) = {
    if (root == null) (List(), true)
    else {
      val left = inorderTraversal(root.left)
      val right = inorderTraversal(root.right)
      val isValid = (left._2 && right._2) && (left._1.isEmpty || left._1.last < root.value) && (right._1.isEmpty || right._1.head > root.value)
      (left._1 ::: root.value :: right._1, isValid)
    }
  }

  def isValid(root: TreeNode, min: BigInt, max: BigInt): Boolean = {
    if (root == null) true
    else {
      if (root.value > min && root.value < max) {
        isValid(root.left, min, root.value) && isValid(root.right, root.value, max)
      }
      else false
    }
  }


  def main(args: Array[String]): Unit = {
    val node0 = new TreeNode(5)
    val node1 = new TreeNode(4)
    val node2 = new TreeNode(7)
    node0.left = node1
    node0.right = node2
    println(isValidBST(node0))
  }
}
