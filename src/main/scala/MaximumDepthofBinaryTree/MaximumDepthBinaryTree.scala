package MaximumDepthofBinaryTree

/**
  * Created by iodone on {19-10-21}.
  */

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}


object Solution {
  import math.max
  def maxDepth(root: TreeNode): Int = {
    if (root == null) 0
    else {
      1 + max(maxDepth(root.left), maxDepth(root.right))
    }
  }
}
