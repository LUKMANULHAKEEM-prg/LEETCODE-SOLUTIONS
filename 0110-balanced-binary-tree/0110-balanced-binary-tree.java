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
    public int isBalancedCheck(TreeNode root){
        if(root == null)return 1;

        int left = isBalancedCheck(root.left);
        int right = isBalancedCheck(root.right);

        if(left == -1 || right == -1)return -1;
        if(Math.abs((left-right))>1)return -1;

        else return left > right ? left + 1 : right + 1;
    }
    public boolean isBalanced(TreeNode root) {
        int val = isBalancedCheck(root);
        if(val == -1)return false;
        return true;
    }
}