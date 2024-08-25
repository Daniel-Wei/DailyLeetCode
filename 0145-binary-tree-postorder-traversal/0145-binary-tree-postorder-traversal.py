# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def _postorder_traversal_helper(self, current_node, result):
        # Base case: if the node is null, return
        if not current_node:
            return
        # Traverse left subtree
        self._postorder_traversal_helper(current_node.left, result)
        # Traverse right subtree
        self._postorder_traversal_helper(current_node.right, result)
        # Add the current node's value to the result list
        result.append(current_node.val)

    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result = []
        # Start traversal from root
        self._postorder_traversal_helper(root, result)
        return result