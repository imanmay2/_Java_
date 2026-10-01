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
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> q1=new LinkedList<>();
        q1.add(root);
        int sum=0;
        while(!q1.isEmpty()){
            TreeNode curr=q1.remove();
            if(curr.left!=null){
                if(curr.left.right==null && curr.left.left==null){
                    sum+=curr.left.val;
                }else{
                    q1.add(curr.left);
                }
            }

            if(curr.right!=null){
                q1.add(curr.right);
            }
        }return sum;
    }
}