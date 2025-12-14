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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Case 1: both null → same
        if (p == null && q == null) return true;

        // Case 2: one null → different
        if (p == null || q == null) return false;

        // Case 3: values differ → different
        if (p.val != q.val) return false;

        // Case 4: check left and right subtrees
        return isSameTree(p.left, q.left) 
            && isSameTree(p.right, q.right);
    }
}
