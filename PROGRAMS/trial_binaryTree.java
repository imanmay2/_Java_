public class trial_binaryTree {

    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class binaryTree{
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode=new Node(nodes[idx]);

            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;
        }


        public static int sumNodes(Node root){
            if(root==null){
                return 0;
            }

            int leftNode=sumNodes(root.left);
            int rightNode=sumNodes(root.right);

            return leftNode+rightNode+root.data;
        }

        public static void levelOrderTraversal(Nodes root){
            if(root==null){
                return;
            }

            
        }
    }
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        binaryTree b1=new binaryTree();
        Node root=b1.buildTree(nodes);
        
        System.out.println("Root of the data: "+root.data);
        
        System.out.println("Sum of the Nodes is: "+b1.sumNodes(root));
    }
}
