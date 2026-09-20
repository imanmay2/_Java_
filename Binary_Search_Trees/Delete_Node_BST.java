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

    public TreeNode findSuccessor(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

    public TreeNode delete(TreeNode root,int key){
        if(root==null){
            return null;
        }

        if(key<root.val){
            //search for left
            root.left=delete(root.left,key);
        }else if(key>root.val){
            //search for right
            root.right=delete(root.right,key);
        }else{
            //target got.
            //case-1 no child
            if(root.left==null && root.right==null){
                return null;
            }
            
            //case-2 only 1 child
            if(root.left==null){
                return root.right;
            }if(root.right==null){
                return root.left;
            }

            else{
                //case-3 having both left and right children. 
                TreeNode successor=findSuccessor(root.right);
                root.val=successor.val;
                root.right=delete(root.right,successor.val);
            }
        }return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root,key);
        
    }
}