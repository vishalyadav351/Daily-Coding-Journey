class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false;
            boolean foundY = false;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.val == x) foundX = true;
                if (current.val == y) foundY = true;

                if (current.left != null && current.right != null) {
                    if ((current.left.val == x && current.right.val == y) ||
                        (current.left.val == y && current.right.val == x)) {
                        return false;
                    }
                }

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            if (foundX && foundY) return true;
            if (foundX || foundY) return false;
        }

        return false;
    }
}