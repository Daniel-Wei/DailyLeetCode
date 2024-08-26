class Solution:
    def postorder(self, root: "Node") -> List[int]:
        result = []
        if not root:
            return result
        self._traverse_postorder(root, result)
        return result

    def _traverse_postorder(
        self, current_node: "Node", postorder_list: List[int]
    ) -> None:
        if not current_node:
            return

        # First, visit all children
        for child_node in current_node.children:
            self._traverse_postorder(child_node, postorder_list)

        # Then, add the current node's value
        postorder_list.append(current_node.val)