/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private ListNode headNode;

    // Helper method to get the length of the linked list
    private int getLength(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }

    private TreeNode sortedListToBSTHelper(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode leftChild = sortedListToBSTHelper(left, mid - 1);

        TreeNode root = new TreeNode(headNode.val);
        root.left = leftChild;

        headNode = headNode.next;

        root.right = sortedListToBSTHelper(mid + 1, right);

        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int n = getLength(head);
        this.headNode = head;
        return sortedListToBSTHelper(0, n - 1);
    }
}