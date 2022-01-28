# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
#     def longestConsecutive(self, root: Optional[TreeNode]) -> int:
#         self.left_in = [1]
#         self.left_de = [1]
#         self.right_in = [1]
#         self.right_de = [1]
#         def dfs(node, currLen, order):
            
            
#             if node.left:
#                 dfs(node.left, 1, 0)
#                 dfs(node.left, 1, 1)
#                 if order == 0:
#                     if node.left.val == node.val - 1:
#                         self.left_de += [currLen + 1]
#                         dfs(node.left, currLen + 1, 0)
                    
                        
#                 if order == 1:
#                     if node.left.val == 1 + node.val:
#                         self.left_in += [currLen + 1]
#                         dfs(node.left, currLen + 1, 1)
                        
#             if node.right:
#                 dfs(node.right, 1, 0)
#                 dfs(node.right, 1, 1)
#                 if order == 0:
#                     if node.right.val == node.val - 1:
#                         self.right_de += [currLen + 1]
#                         dfs(node.right, currLen + 1, 0)
                        
#                 if order == 1:
#                     if node.right.val == 1 + node.val:
#                         self.right_in += [currLen + 1]
#                         dfs(node.right, currLen + 1, 1)
                        
               
                    
                   
        
        # dfs(root, 1, 0)
#         dfs(root, 1, 1)
#         print(self.left_in)
#         print(self.left_de)
#         print(self.right_in)
#         print(self.right_de)
        
#         op1 = 0
#         op2 = 0
        
#         if len(self.left_in) > 1 and len(self.right_de) > 1:
#             op1 = max(self.left_in) + max(self.right_de) - 1
#         else:
#             op1 = max(max(self.left_in) , max(self.right_de)) 
            
#         if len(self.left_de) > 1 and len(self.right_in) > 1:
#             op2 = max(self.left_de) + max(self.right_in) - 1
#         else:
#             op2 = max(max(self.left_de) ,max(self.right_in)) 
            
            
                
        
#         return max(op1, op2)

    def longestConsecutive(self, root: TreeNode) -> int:
        def longest_path(root):
            if not root:
                return 0, 0
            inc, dec = 1, 1
            l_inc, l_dec = longest_path(root.left)
            r_inc, r_dec = longest_path(root.right)
            if root.left:
                if root.left.val == root.val + 1:
                    inc = max(inc, 1 + l_inc)
                if root.left.val == root.val - 1:
                    dec = max(dec, 1 + l_dec)
            if root.right:
                if root.right.val == root.val + 1:
                    inc = max(inc, 1 + r_inc)
                if root.right.val == root.val - 1:
                    dec = max(dec, 1 + r_dec)
            res[0] = max(res[0], inc + dec - 1)
            return (inc, dec)
        
        res = [0]
        longest_path(root)
        return res[0]
            
        