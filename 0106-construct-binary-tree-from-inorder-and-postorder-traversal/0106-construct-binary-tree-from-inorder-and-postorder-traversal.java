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
import java.util.*;

class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        postIndex = postorder.length - 1;

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int left, int right) {

        if (left > right)
            return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int mid = map.get(rootVal);

        // Build right first because we're moving backwards in postorder
        root.right = build(inorder, postorder, mid + 1, right);
        root.left = build(inorder, postorder, left, mid - 1);

        return root;
    }
}