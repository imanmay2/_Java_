                                                 // Practising Binary Trees, basics///


public class BinaryTrees{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }


    static class Binary_Tree{
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            // Building up the Binary Tree.
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }
    }
    public static void main(String args[]){
        int nodes[]={10,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binary_Tree tree=new Binary_Tree();
        Node root=tree.buildTree(nodes);
        System.out.println("The root is : "+ root.data);
    }
}