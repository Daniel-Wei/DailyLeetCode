# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def removeLeafNodes(self, root: Optional[TreeNode], target: int) -> Optional[TreeNode]:
        self.tar = target
        self.root = root
        def dfs(parent, curr, dire=None):
            if not curr:
                return True
            if not curr.left and not curr.right and curr.val == self.tar:
                if dire == 0:
                    parent.left = None
                else:
                    parent.right = None
                return True
            left = dfs(curr, curr.left, 0)
            right = dfs(curr, curr.right, 1)
            if left and right and curr.val == self.tar:
                if dire == 0:
                    parent.left = None
                elif dire == 1:
                    parent.right = None
                else:
                    self.root = None
                return True
            else:
                return False
        dfs(None, self.root)
        return self.root
        
                    
                
            
            
            
            
            