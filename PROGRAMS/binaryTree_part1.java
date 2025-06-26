import java.util.*;
import java.util.LinkedList;
public class binaryTree_part1 {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree_ {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preOrderTraversal(Node root) {
            if (root == null) {
                // System.out.print("-1 ");
                return;
            }
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }

        public static void inOrderTraversal(Node root) {
            if (root == null) {
                // System.out.print("-1 ");
                return;
            }
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }

        public static void postOrderTraversal(Node root) {
            if (root == null) {
                // System.out.print("-1 ");
                return;
            }
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }

        public static int sumNodes(Node root) {
            if (root == null) {
                return 0;
            }
            return sumNodes(root.left) + sumNodes(root.right) + root.data;
        }

        public static int countNodes(Node root) {
            if (root == null) {
                return 0;
            }
            return countNodes(root.left) + countNodes(root.right) + 1;
        }

        public static int maxHeightNode(Node root) {
            if (root == null) {
                return 0;
            }
            return Math.max(countNodes(root.left), countNodes(root.right)) + 1;
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
                if(currNode==null){
                    if(q1.isEmpty()){
                        break;
                    }
                    q1.add(null);
                } else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q1.add(currNode.left);
                    } if(currNode.right!=null){
                        q1.add(currNode.right);
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree_ b1 = new BinaryTree_();
        Node root = b1.buildTree(nodes);
        // System.out.println("Tree build is: " + root.data);
        // System.out.println();
        // b1.preOrderTraversal(root);
        // System.out.println();
        // b1.inOrderTraversal(root);
        // System.out.println();
        // b1.postOrderTraversal(root);
        // System.out.println();
        // System.out.print("Sum of the nodes is : " + b1.sumNodes(root));
        // System.out.println();
        // System.out.print("Sum of the nodes is : " + b1.countNodes(root));

        // System.out.println();
        // System.out.print("Maximum height of the nodes is : " + b1.maxHeightNode(root));

        System.out.println();
        b1.levelOrderTraversal(root);
    }
}