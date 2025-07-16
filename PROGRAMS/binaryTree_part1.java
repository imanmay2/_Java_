public class binaryTree_part1{

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            Node left=null;
            Node right=null;
        }
    }


    static class binaryTree{
        static int idx=-1;
        
        public Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return;
            }
            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }
    }
    public static void main(String args[]){
        
    }
}