/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public void levelOrder(Node root){
        Queue<Node> q1=new LinkedList<>();
        q1.add(root);

        while(!q1.isEmpty()){
            //check the size of queue.
            int size=q1.size();
            for(int i=0;i<size;i++){
                Node curr=q1.remove();
                if(i==size-1){
                    curr.next=null;
                }else{
                    curr.next=q1.peek();
                }
                if(curr.left!=null){
                    q1.add(curr.left);
                }
                if(curr.right!=null){
                    q1.add(curr.right);
                }
            }
        }
    }
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        levelOrder(root);
        return root;
    }
}