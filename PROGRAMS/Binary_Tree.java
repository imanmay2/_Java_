import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
public class Binary_Tree {
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

    static class binaryTree {
        static int idx = -1;
        Queue<Integer> q1 = new ArrayDeque<>();

        public Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public void preOrderTraversal(Node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }

        public void inOrderTraversal(Node root) {
            if (root == null) {
                return;
            }
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }

        public void postOrderTraversal(Node root) {
            if (root == null) {
                return;
            }
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }

        public void levelOrderTraversal(Node root){
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
                    } if(currNode.right!=null){
                        q1.add(currNode.right);
                    }

                }else{
                    System.out.println();
                    if(q1.isEmpty()){
                        break;
                    }
                    q1.add(null);
                }
            }
        }

        public int sumNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int left = sumNodes(root.left);
            int right = sumNodes(root.right);
            return left + right + root.data;
        }

        public int countNodes(Node root) {
            if (root == null) {
                return 0;
            }

            int left = countNodes(root.left);
            int right = countNodes(root.right);
            return left + right + 1; // calculating the count of the node.
        }

        public int heightNode(Node root) {
            if (root == null) {
                return 0;
            }
            int left = heightNode(root.left);
            int right = heightNode(root.right);
            return Math.max(left, right) + 1;
        }

    }

    public static void main(String args[]) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        binaryTree tree = new binaryTree();
        Node root = tree.buildTree(nodes);
        

        System.out.println();
        tree.levelOrderTraversal(root);
    }
}