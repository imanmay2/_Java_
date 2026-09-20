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
class BSTIterator {
    TreeNode root;
    boolean flag=false;
    Queue<Integer> q1=new LinkedList<>();
    private void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        q1.add(root.val);
        inorder(root.right);
    }

    public BSTIterator(TreeNode root) {
        this.root=root;
    }
    
    public int next() {
        if(!flag){
            inorder(root);
            flag=true;
        }

        if(q1.size()>0){
            return q1.remove();
        }
        return -1;
    }
    
    public boolean hasNext() {
        if(!flag){
            inorder(root);
            flag=true;
        }
        if(q1.size()>0){
            return true;
        } return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */