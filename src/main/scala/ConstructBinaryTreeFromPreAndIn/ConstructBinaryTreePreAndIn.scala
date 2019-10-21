package ConstructBinaryTreeFromPreAndIn

/**
  * Created by iodone on {19-10-21}.
  */

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    if (preorder.isEmpty || inorder.isEmpty) null
    else {
      val rValue = preorder(0)
      val rIndex = inorder.indexOf(rValue)
      val leftInOrder = inorder.slice(0, rIndex)
      val rightInOrder = inorder.slice(rIndex + 1, inorder.length)
      val leftPreOrder = preorder.slice(1, leftInOrder.length+1)
      val rightPreOrder = preorder.slice(leftInOrder.length+1, preorder.length)

      val leftTreeNode = buildTree(leftPreOrder, leftInOrder)
      val rightTreeNode = buildTree(rightPreOrder, rightInOrder)
      val root = new TreeNode(rValue)
      root.left = leftTreeNode
      root.right = rightTreeNode
      root
    }
  }
  def inorderTraversal(root: TreeNode): List[Int] = {
    if (root == null) List()
    else {
      inorderTraversal(root.left) ::: root.value :: inorderTraversal(root.right)
    }
  }

  def main(args: Array[String]): Unit = {
    val tree = buildTree(Array(3,9,20,15,7), Array(9,3,15,20,7))
    println(inorderTraversal(tree))
  }
}
