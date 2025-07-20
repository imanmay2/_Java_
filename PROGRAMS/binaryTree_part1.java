public class binaryTree_part1{

    static class Node{
        Node left;
        Node right;
        int data;

        Node(int data){
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


        //preOrderTraversal.
        public static void preOrderTraversal(Node root){
            if(root==null){
               
                return;
            }

            System.out.print(root.data+" ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }

        //inOrder Traversal.
        public static void inOrderTraversal(Node root){
            if(root==null){
                return;
            }

            inOrderTraversal(root.left);
            System.out.print(root.data+" ");
            inOrderTraversal(root.right);
        }

        //postOrder traversal.
        public static void postOrderTraversal(Node root){
            if(root==null){
                return;
            }

            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data+" ");
        }


        //Sum of the Nodes.
        public static int sumNodes(Node root){
            if(root==null){
                return 0;
            }
            int leftNode=sumNodes(root.left);
            int rightNode=sumNodes(root.right);
            return leftNode+rightNode+root.data;
        }


        //Count of the Nodes.
        public static int countNodes(Node root){
            if(root==null){
                return 0;
            }

            int leftNode=countNodes(root.left);
            int rightNode=countNodes(root.right);
            return leftNode+rightNode+1;
        }

        // height of the Nodes.
        public static int heightNodes(Node root){
            if(root==null){
                return 0;
            }

            int leftNode=heightNodes(root.left);
            int rightNode=heightNodes(root.right);

            return Math.max(leftNode, rightNode)+1;
        }


        //Level Order Traversal. 
        
    }
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        binaryTree b1=new binaryTree();
        Node root=b1.buildTree(nodes);
        System.out.println("Root is : "+root.data);
        System.out.println("PreOrder Traversal");
        b1.preOrderTraversal(root);
        System.out.println();
        System.out.println("InOrder Traversal");
        b1.inOrderTraversal(root);
        System.out.println();
        System.out.println("PostOrder Traversal");
        b1.postOrderTraversal(root);

        System.out.println();
        System.out.println("Sum of the Nodes : ");
        System.out.println(b1.sumNodes(root));

        System.out.println();
        System.out.println("Count of the Nodes : ");
        System.out.println(b1.countNodes(root));

        System.out.println();
        System.out.println("Height of the Nodes : ");
        System.out.println(b1.heightNodes(root));
    }
}