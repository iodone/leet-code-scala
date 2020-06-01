package MaximumDepthofBinaryTree

/**
  * Created by iodone on {19-10-21}.
  */

/**
  * 解题报告
  * 
  * 说明：采用递归思路
  * 
  * 思路：左右子树的最大深度+1
  *
  * @param _value
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
