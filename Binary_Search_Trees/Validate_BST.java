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


 //NOTE : REMEMBER THE static flag issue you faced. don't use global static flag, output won't come as "static" will store the variables prev value bw the calls. 


 //NOTE : use long datatype instead of int, as edge case has Integer max value, which is not satisfying the condition. 
class Solution {
    public class Info{
        boolean isBST;
        long min;
        long max;
        public Info(boolean isBST,long min,long max){
            this.isBST=isBST;
            this.min=min;
            this.max=max;
        }
    }

    public Info validBST(TreeNode root){
        if(root==null){
            return new Info(true,Long.MAX_VALUE,Long.MIN_VALUE);
        }

        //gain info from child. 
        Info left=validBST(root.left);
        Info right=validBST(root.right);
        
        Long min=Math.min(root.val,Math.min(left.min,right.min));
        Long max=Math.max(root.val,Math.max(left.max,right.max));

        //check valid BST or not including the root.
        if(left.isBST && right.isBST && root.val>left.max && root.val<right.min){
            return new Info(true,min,max);
        }
        return new Info(false,min,max);
    }
    public boolean isValidBST(TreeNode root){
        return validBST(root).isBST;
    }
}