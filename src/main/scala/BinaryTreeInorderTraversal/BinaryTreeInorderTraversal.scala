package BinaryTreeInorderTraversal

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}


/**
  * 解题报告
  * 
  * 说明：二叉树数一般采用递归思路，很容易分解成子问题
  * 
  * 思路：中序遍历 [left 子问题 + value + right 子问题]
  * 
  */
object Solution {
  def inorderTraversal(root: TreeNode): List[Int] = {
    if (root == null) List()
    else {
      inorderTraversal(root.left) ::: root.value :: inorderTraversal(root.right)
    }
  }
}
