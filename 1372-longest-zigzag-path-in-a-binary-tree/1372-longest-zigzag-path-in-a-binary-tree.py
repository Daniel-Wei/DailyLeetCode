# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def track(self, curr: TreeNode, length: int, last: int) -> int:
        left = 0
        right = 0
        if last is 0:
            if curr.left is not None:
                left = self.track(curr.left, 1, 0)
            if curr.right is None:
                right = length
            else:
                right =  self.track(curr.right, length+1, 1)
        else:
            if curr.right is not None:
                right = self.track(curr.right, 1, 1)
            if curr.left is None:
                left =  length
            else:
                left = self.track(curr.left, length+1, 0)
                
        return max(left, right)
    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        else:
            left = 0
            right = 0
            if root.left is not None:
                left = self.track(root.left, 1, 0)
            if root.right is not None:
                right = self.track(root.right, 1, 1)
            
            
            return max(left, right)
    
        