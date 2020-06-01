package FlattenBinaryTree

/**
  * Created by iodone on {19-10-22}.
  */


/**
  * 
  * 解题报告
  * 
  * 思路：递归思路，类似前序遍历的方式，不过最后是用树来表达最终结果。由于是前序：root+flattern(left)+flattern(right)，很明显flattern(left)的尾部是缺失，需要先定位到flattern(left)的lastnode,
  * 以便能够连接到flattern(right)
  *
  */
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def flatten(root: TreeNode): Unit = {
    if (root == null) root 
    else {
      root.right = flattenTree(root).right
      root.left = null
    }
  }

  def flattenTree(root: TreeNode): TreeNode = {
    if (root == null) null
    else {
      val newRoot = new TreeNode(root.value)
      val leftRoot = flattenTree(root.left)
      val rightRoot = flattenTree(root.right)
      var lastLeftNode = leftRoot
      if (lastLeftNode == null) {
        newRoot.right = rightRoot
      } else {
        while(lastLeftNode.right != null) lastLeftNode = lastLeftNode.right
        lastLeftNode.right = rightRoot
        newRoot.right = leftRoot
      }
      newRoot
    }
  }
}
