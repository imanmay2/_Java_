import java.util.*;
import java.util.LinkedList;
public class Binary_Trees {

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
        public static Node buildTree(int[] arr){
            idx++;
            if(arr[idx]==-1){
                return null;
            }
            Node newNode=new Node(arr[idx]);
            newNode.left=buildTree(arr);
            newNode.right=buildTree(arr);
            return newNode;
        }



        public static void pre_order_Traversal(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            pre_order_Traversal(root.left);
            pre_order_Traversal(root.right);
        }



        public static void in_order_traversal(Node root){
            if(root==null){
                return;
            }
            in_order_traversal(root.left);
            System.out.print(root.data+" ");
            in_order_traversal(root.right);
        }



        public static void post_order_traversal(Node root){
            if(root==null){
                return;
            }
            post_order_traversal(root.left);
            post_order_traversal(root.right);
            System.out.print(root.data+" ");
        }


        public static void level_order_traversal(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q1=new LinkedList<>();
            q1.add(root);
            q1.add(null);
            while(!q1.isEmpty()){
                Node curr=q1.remove();
                if(curr!=null){
                    System.out.print(curr.data+" ");
                    if(curr.left!=null){
                        q1.add(curr.left);
                    }
                    if(curr.right!=null){
                        q1.add(curr.right);
                    }
                }
                else{
                    System.out.println("");
                    if(q1.isEmpty()){
                        break;
                    }
                    else{
                        q1.add(null);
                    }
                }
            }

            
        }

        public static void count_Nodes(Node root){
            if(root==null){
                return;
            }
            int left_subtree=count_Node(root.left);
            int right_subtree=count_Node(root.right);
            int count=left_subtree+right_subtree+1;
            System.out.println(count);
        }
    }

    



    public static void main(String args[]){
        int[] arr={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root=binaryTree.buildTree(arr);
        // System.out.println(root.data);
        // System.out.println();
        // binaryTree.pre_order_Traversal(root);
        // System.out.println();
        // binaryTree.in_order_traversal(root);
        // System.out.println();
        // binaryTree.post_order_traversal(root);
        // binaryTree.level_order_traversal(root);
        count_Nodes(root);
    }
}
