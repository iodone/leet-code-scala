package FlattenBinaryTree

/**
  * Created by iodone on {19-10-22}.
  */

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def flatten(root: TreeNode): Unit = {
    if (root == null) null
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
