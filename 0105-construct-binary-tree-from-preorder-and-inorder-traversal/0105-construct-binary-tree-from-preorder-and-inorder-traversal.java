class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, java.util.Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int leftSize = inRoot - inStart;

        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, inRoot - 1, map);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, inRoot + 1, inEnd, map);

        return root;
    }
}