class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    
    private void helper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);         
        helper(node.left, result);     
        helper(node.right, result);   
    }
}