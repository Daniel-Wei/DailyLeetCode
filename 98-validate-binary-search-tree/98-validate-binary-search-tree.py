# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        if not root:
            return True
        
        def getLeftVals(node, left):
            if node:
                left += [node.val]
                getLeftVals(node.left, left)
                getLeftVals(node.right, left)
                
        def getRightVals(node, right):
            if node:
                right += [node.val]
                getRightVals(node.left, right)
                getRightVals(node.right, right)
                
        
        def isValid(node):
            left = []
            right = []
                
            getLeftVals(root.left, left)
            getRightVals(root.right, right)
        
            # print(left)
            # print(right)
                
            if (not left or root.val > max(left)) and (not right or root.val < min(right)):
                return True
        
            return False
        
        return isValid(root) and self.isValidBST(root.left) and self.isValidBST(root.right)
            
                
            
    