# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        def same(root, subRoot):
            if not root and not subRoot:
                return True
            if (root and not subRoot) or (not root and subRoot):
                return False
            if root.val == subRoot.val:
                return same(root.left, subRoot.left) and same(root.right, subRoot.right)
            return False
        if not root:
            return False
        
        return same(root, subRoot) or self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)
    
    
        