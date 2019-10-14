package BinaryTreeInorderTraversal

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def inorderTraversal(root: TreeNode): List[Int] = {
    if (root == null) List()
    else {
      inorderTraversal(root.left) ::: root.value :: inorderTraversal(root.right)
    }
  }
}
