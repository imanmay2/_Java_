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
    List<String> list=new ArrayList<>();

    //Basic Idea : 
    //Check if there is length of string builder is > 0, if yes then : add " ->" and then add the root
    //                                                   if no , thn : only add root(if first time adding)
    //                                                   backtrack after preorder left and right. 
    
    public void preOrder(TreeNode root,StringBuilder sb){
        int len=sb.length();
        if(root==null){
            return;
        }
        if(len>0){
            sb.append("->");
        }
        sb.append(Integer.toString(root.val));
        if(root.left==null && root.right==null){
            list.add(sb.toString());
        }else{
            preOrder(root.left,sb);
            preOrder(root.right,sb);
        }

        //backtrack
        sb.setLength(len);
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preOrder(root,sb);
        return list;
    }
}