/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;
        TreeNode pred = null;
        
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                pred = current.left;
                while (pred.right != null && pred.right != current) {
                    pred = pred.right;
                }
                
                if (pred.right == null) {
                    pred.right = current;
                    current = current.left;
                } else {
                    pred.right = null;
                    if (prev != null && prev.val > current.val) {
                        if (first == null) {
                            first = prev;
                            second = current; 
                        } else {
                            second = current; 
                        }
                    }
                    prev = current;
                    current = current.right;
                }
            } else {
                if (prev != null && prev.val > current.val) {
                    if (first == null) {
                        first = prev;
                        second = current;
                    } else {
                        second = current;
                    }
                }
                prev = current;
                current = current.right;
            }
        }
       
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}