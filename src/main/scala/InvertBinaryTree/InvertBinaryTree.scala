package InvertBinaryTree

/**
  * Created by iodone on {19-11-1}.
  */
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def invertTree(root: TreeNode): TreeNode = {
    if (root == null) null
    else {
      val newNode = new TreeNode(root.value)
      newNode.right = invertTree(root.left)
      newNode.left = invertTree(root.right)
      newNode
    }
  }
}
