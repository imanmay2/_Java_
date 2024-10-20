// Practising Binary Trees, basics///

import java.util.LinkedList;
import java.util.Queue;
public class BinaryTrees {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    static class Binary_Tree {
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            // Building up the Binary Tree.
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }


        public static void pre_order_Traversal(Node root) {
            // Printing the Binary Tree in the pre-order traversal format--- Root --> Left
            // -->Right.
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            pre_order_Traversal(root.left);
            pre_order_Traversal(root.right);
        }


        public static void in_Order_Traversal(Node root) {
            // Printing the Binary Tree in the in-order traversal format--- Left -->Root
            // -->Right.
            if (root == null) {
                return;
            }
            in_Order_Traversal(root.left);
            System.out.print(root.data + " ");
            in_Order_Traversal(root.right);
        }


        public static void post_Order_Traversal(Node root) {
            // Printing the Binary Tree in the pre-order traversal format--- Left
            // -->Right--->Root.
            if (root == null) {
                return;
            }
            post_Order_Traversal(root.left);
            post_Order_Traversal(root.right);
            System.out.print(root.data + " ");
        }


        public static void level_Order_Traversal(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode != null) {
                    System.out.print(currNode.data);
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                } else {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                }
            }
        }
        


        public static int sumNode(Node root){
            if(root==null){
                return 0;
            }
            int left_sum=sumNode(root.left);
            int right_sum=sumNode(root.right);
            return left_sum+right_sum+root.data;
        }

        public static int countNode(Node root) {
            if (root == null) {
                return 0;
            }
            int left_count = countNode(root.left);
            int right_count = countNode(root.right);
            return left_count + right_count + 1;
        }

        public static int heightTree(Node root){
            if(root==null){
                return 0;
            }
            int left_height=heightTree(root.left);
            int right_height=heightTree(root.right);
            return Math.max(left_height, right_height)+1;
        }


        public static int diameterTree(Node root){
            if(root==null){
                return 0;
            }
            int leftDiameter=diameterTree(root.left);
            int rightDiameter=diameterTree(root.right);
            int leftHeight=heightTree(root.left);
            int rightHeight=heightTree(root.right);
            int diameter=leftHeight+rightHeight+1;
            return Math.max(leftDiameter,Math.max(rightDiameter,diameter));
        }
    }


    public static void main(String args[]) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Binary_Tree tree = new Binary_Tree();
        Node root = tree.buildTree(nodes);
        // System.out.println("The root is : " + root.data);
        // System.out.println();
        // tree.pre_order_Traversal(root);
        // System.out.println();
        // tree.in_Order_Traversal(root);
        // System.out.println();
        // tree.post_Order_Traversal(root);
        // System.out.println();
        // System.out.println("Level order Traversal : ");
        // tree.level_Order_Traversal(root);
        // System.out.println("Sum of the Nodes is : "+tree.sumNode(root));
        // System.out.println("Count of the Nodes is : "+tree.countNode(root));
        // System.out.println();
        // System.out.println("Height of the Tree is : "+tree.heightTree(root));
        System.out.println(tree.diameterTree(root));
    }
}