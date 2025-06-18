import java.util.ArrayDeque;
import java.util.Queue;
public class Binary_Tree {
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
        Queue<Integer> q1=new ArrayDeque<>();
        public Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }


        public void preOrderTraversal(Node root){
            if(root==null){
                return;
            }

            System.out.print(root.data+" ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }


        public void inOrderTraversal(Node root){
            if(root==null){
                return;
            }
            inOrderTraversal(root.left);
            System.out.print(root.data+" ");
            inOrderTraversal(root.right);
        }


        public void postOrderTraversal(Node root){
            if(root==null){
                return;
            }

            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data+" ");
        }


       public int sumNodes(Node root){
        if(root==null){
            return 0;
        }
        int left=sumNodes(root.left);
        int right=sumNodes(root.right);
        return left+right+root.data;
       }


       public int countNodes(Node root){
        if(root==null){
            return 0;
        }

        int left=countNodes(root.left);
        int right=countNodes(root.right);
        return left+right+1;   //calculating the count of the node.
       }


       public int heightNode(Node root){
        if(root==null){
            return 0;
        }
        int left=heightNode(root.left);
        int right=heightNode(root.right);
        return Math.max(left, right)+1;
       }
    }
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        binaryTree tree=new binaryTree();
        Node root=tree.buildTree(nodes);
        System.out.println(root.data);
        System.out.println();
        System.out.println("PreOrder Traversal : ");
        tree.preOrderTraversal(root);
        
        System.out.println();
        System.out.println("InOrder Traversal : ");
        tree.inOrderTraversal(root);

        System.out.println();
        System.out.println("PostOrder Traversal : ");
        tree.postOrderTraversal(root);
        System.out.println();
        System.out.println("Sum of the Nodes are: "+tree.sumNodes(root));
        System.out.println();
        System.out.println("Sum of the Nodes are: "+tree.countNodes(root));
         System.out.println();
        System.out.println("Max height of the Nodes are: "+tree.heightNode(root));
    }
}