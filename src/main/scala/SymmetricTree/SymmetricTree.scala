package SymmetricTree

/**
  * Created by iodone on {19-10-17}.
  */

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def isSymmetric(root: TreeNode): Boolean = {
//    compareTree(root, reverseTree(root))
    if (root == null) true
    else {
      isMirror(root.left, root.right)
    }
  }

  def isMirror(root0: TreeNode, root1: TreeNode): Boolean = {
    if (root0 == null && root1 == null) true
    else if (root0 == null || root1 == null) false
    else {
      root0.value == root1.value && isMirror(root0.left, root1.right) && isMirror(root0.right, root1.left)
    }
  }


  // traversal result equal not tree equal
  def inorderTraversal(root: TreeNode): List[Int] = {
    if (root == null) List()
    else {
      inorderTraversal(root.left) ::: root.value :: inorderTraversal(root.right)
    }
  }

  def compareTree(root0: TreeNode, root1: TreeNode): Boolean = {
    if (root0 == null && root1 == null) true
    else if (root0 == null || root1 == null) false
    else {
      root0.value == root1.value && compareTree(root0.left, root1.left) && compareTree(root0.right, root1.right)
    }
  }

  def reverseTree(root: TreeNode): TreeNode = {
    if (root == null) null
    else {
      val left = reverseTree(root.left)
      val right = reverseTree(root.right)
      val newNode = new TreeNode(root.value)
      newNode.left = right
      newNode.right = left
      newNode
    }
  }
}
