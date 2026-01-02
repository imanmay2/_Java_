import java.util.Queue;
import java.util.LinkedList;
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

        public static void levelOrderTraversal(Node root){
            if(root==null){
                return;
            }

            Queue<Node> q1=new LinkedList<>();
            q1.add(root);
            q1.add(null);

            while(!q1.isEmpty()){
                Node currNode=q1.remove();
                
                if(currNode!=null){
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q1.add(currNode.left);
                    } if(currNode.right!=null){
                        q1.add(currNode.right);
                    }
                } else if(currNode==null){
                    if(q1.isEmpty()){
                        break;
                    } else{
                        q1.add(null);
                    }
                }
            }
        }
    }
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        binaryTree b1=new binaryTree();
        Node root=b1.buildTree(nodes);
        
        System.out.println("Root of the data: "+root.data);
        
        System.out.println("Sum of the Nodes is: "+b1.sumNodes(root));

        System.out.println("Level Order Traversal");
        b1.levelOrderTraversal(root);
    }
}
