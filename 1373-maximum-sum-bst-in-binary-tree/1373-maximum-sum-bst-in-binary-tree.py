# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    
    def maxSumBST(self, root: Optional[TreeNode]) -> int:
        self.ans = 0
        if root is None:
            return 0
        self.dfsBST(root)
        
        return self.ans
    
    # return (low, high, sum, isBST)
    def dfsBST(self, node) -> tuple:
        isBST = False
        
        # null node的最小值很大 一定大于上一个node
        # null node的最大值很小 一定小于上一个node
        if node is None:
            return(1e9, -1e9, 0, True)
        
        currSum = -1
        
        left = self.dfsBST(node.left)
        right = self.dfsBST(node.right)
        
        if left[3] and right[3] and left[1] < node.val and right[0] > node.val:
            currSum = left[2] + right[2] + node.val
            isBST = True
        self.ans = max(self.ans, currSum)
        
        # min max 只是为了null node的情况
        return (min(left[0], node.val), max(right[1], node.val), currSum, isBST)              