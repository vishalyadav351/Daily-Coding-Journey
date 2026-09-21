class Solution {
    public Node connect(Node root) {
        Node curr = root;
        Node head = null;
        Node tail = null;
        while (curr != null) {
            while (curr != null) {
                if (curr.left != null) {
                    if (tail != null) {
                        tail.next = curr.left;
                    } else {
                        head = curr.left;
                    }
                    tail = curr.left;
                }
                if (curr.right != null) {
                    if (tail != null) {
                        tail.next = curr.right;
                    } else {
                        head = curr.right;
                    }
                    tail = curr.right;
                }
                curr = curr.next;
            }
            curr = head;
            head = null;
            tail = null;
        }
        return root;
    }
}