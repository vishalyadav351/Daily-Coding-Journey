class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root.val == 0) return false;
        if (root.val == 1) return true;
        
        boolean leftVal = evaluateTree(root.left);
        boolean rightVal = evaluateTree(root.right);
        
        if (root.val == 2) {
            return leftVal || rightVal;
        } else {
            return leftVal && rightVal;
        }
    }
}