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
    int maxSum=Integer.MIN_VALUE;
    public int sum(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftSum=sum(root.left);
        int rightSum=sum(root.right);
        maxSum=Math.max(maxSum,root.val+Math.max(0,leftSum)+Math.max(0,rightSum));

        return root.val+Math.max(Math.max(0,leftSum),Math.max(0,rightSum));
    }
    public int maxPathSum(TreeNode root) {
        sum(root);
        return maxSum;
    }
}