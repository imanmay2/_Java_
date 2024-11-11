import java.util.LinkedList;
import java.util.Queue;

public class binaryTree_practise{
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

        public static void preOrderTraversal(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }


        public static void inOrderTraversal(Node root){
            if(root==null){
                return;
            }
            inOrderTraversal(root.left);
            System.out.print(root.data+" ");
            inOrderTraversal(root.right);
        }

        public static void postOrderTraversal(Node root){
            if(root==null){
                return;
            }
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data+" ");
        }


        public static void levelOrderTraversal(Node root){
            Queue<Node> q1=new LinkedList<>();
            if(root==null){
                return;
            }
            q1.add(root);
            q1.add(null);
            while(!q1.isEmpty()){
                Node currNode=q1.remove();
                if(currNode!=null){
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q1.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q1.add(currNode.right);
                    }
                }
                else if(currNode==null){
                    System.out.println();
                    if(!q1.isEmpty()){
                        q1.add(null);
                    }
                    else if(q1.isEmpty()){
                        break;
                    }
                }
            }
        }

        public static int sumNode(Node root){
            if(root==null){
                return 0;
            }
            return sumNode(root.left)+sumNode(root.right)+root.data;
        }

        public static int countNode(Node root){
            if(root==null){
                return 0;
            }
            return countNode(root.left)+countNode(root.right)+1;
        }
    }
    public static void main(String args[]){
        binaryTree tree=new binaryTree();
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root=tree.buildTree(nodes);
        System.out.println("Root is : "+root.data);
        tree.preOrderTraversal(root);
        System.out.println();
        tree.inOrderTraversal(root);
        System.out.println();
        tree.postOrderTraversal(root);
        System.out.println();
        tree.levelOrderTraversal(root);
        System.out.println();
        System.out.println("Sum of the Nodes : "+tree.sumNode(root));
        System.out.println();
        System.out.println("Count of the nodes : "+tree.countNode(root));
    }
}