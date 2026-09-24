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
    class Info{
        boolean isBST;
        int min,max;
        int sum;
        public Info(boolean isBST,int min,int max,int sum){
            this.isBST=isBST;
            this.min=min;
            this.max=max;
            this.sum=sum;
        }
    }

    public int maxSum=0;

    public Info sum(TreeNode root){
        if(root==null){
            return new Info(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }

        //fetch details from child.
        Info left=sum(root.left);
        Info right=sum(root.right);
        
        //store the current sum path.
        int s=left.sum+right.sum+root.val;

        //store the updated min and max value via comparing with the root.

        int min=Math.min(root.val,Math.min(left.min,right.min));
        int max=Math.max(root.val,Math.max(left.max,right.max));
        //check whether BST or not. 
        if(left.isBST && right.isBST && root.val>left.max && root.val<right.min){
            maxSum=Math.max(maxSum,s);
            return new Info(true,min,max,s);
        }
        return new Info(false,min,max,s);
    }
    public int maxSumBST(TreeNode root) {
        sum(root);
        return maxSum;
    }
}