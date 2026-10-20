import java.util.*;

class Solution {
    private Integer prevVal = null;
    private int currCount = 0;
    private int maxCount = 0;
    private List<Integer> modesList = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] result = new int[modesList.size()];
        for (int i = 0; i < modesList.size(); i++) {
            result[i] = modesList.get(i);
        }
        return result;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        
        inorder(node.left);
        
        if (prevVal != null && prevVal == node.val) {
            currCount++;
        } else {
            currCount = 1;
            prevVal = node.val;
        }
        
        if (currCount > maxCount) {
            maxCount = currCount;
            modesList.clear();
            modesList.add(node.val);
        } else if (currCount == maxCount) {
            modesList.add(node.val);
        }
        
        inorder(node.right);
    }
}