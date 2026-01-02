import java.util.*;
import java.util.LinkedList;

public class binaryTree__2 {
    static int idx = -1;

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

    // static class Info {
    //     int height;
    //     int diameter;

    //     public Info(int height, int diameter) {
    //         this.height = height;
    //         this.diameter = diameter;
    //     }
    // }

    static class Info {
        Node node;
        int hd;

        public Info(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    static class BinaryTree2 {
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

        // public static int height(Node root) {
        //     if (root == null) {
        //         return 0;
        //     }
        //     int left = height(root.left);
        //     int right = height(root.right);
        //     return Math.max(left, right) + 1;
        // }

        // public static int treeDiameter(Node root) {
        //     if (root == null) {
        //         return 0;
        //     }
        //     int lh = height(root.left);
        //     int rh = height(root.right);
        //     int ld = treeDiameter(root.left);
        //     int rd = treeDiameter(root.right);
        //     return Math.max(Math.max(ld, rd), (lh + rh + 1));
        // }

        // public static Info treeDiameter2(Node root) {
        //     if (root == null) {
        //         return new Info(0, 0);
        //     }

        //     Info leftInfo = treeDiameter2(root.left);
        //     Info rightInfo = treeDiameter2(root.right);

        //     int diameter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter),
        //             leftInfo.height + rightInfo.height + 1);
        //     int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        //     return new Info(height, diameter);
        // }

        // public static boolean isSubtree(Node root, Node subRoot) {
        //     // base case
        //     if (root == null) {
        //         return false;
        //     }

        //     if (root.data == subRoot.data) {
        //         if (isIdentical(root, subRoot)) {
        //             return true;
        //         }
        //     }
        //     return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        // }

        // public static boolean isIdentical(Node root, Node subRoot) {
        //     if (root == null && subRoot == null) {
        //         return true;
        //     } else if (root == null || subRoot == null || root.data != subRoot.data) {
        //         return false;
        //     } else if (!isIdentical(root.left, subRoot.left)) {
        //         return false;
        //     } else if (!isIdentical(root.right, subRoot.right)) {
        //         return false;
        //     }
        //     return true;
        // }

        public static void topView(Node root) {
            int min = 0;
            int max = 0;
            Queue<Info> q1 = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();
            q1.add(new Info(0, root));
            q1.add(null);

            while (!q1.isEmpty()) {
                Info curr = q1.remove();
                if (curr == null) {
                    if (q1.isEmpty()) {
                        break;
                    } else {
                        q1.add(null);
                    }
                } else {
                    if (!map.containsKey(curr.hd)) {
                        map.put(curr.hd, curr.node);
                    }
                    if (curr.node.left != null) {
                        q1.add(new Info(curr.hd - 1, curr.node.left));
                        min = Math.min(min, curr.hd - 1);
                    }
                    if (curr.node.right != null) {
                        q1.add(new Info(curr.hd + 1, curr.node.right));
                        max = Math.max(max, curr.hd + 1);
                    }
                }
            }

            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).data+" ");
            }
        }
    }

    public static void main(String args[]) {
        BinaryTree2 tree = new BinaryTree2();
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int node2[] = { 2, 4, -1, -1, 5, -1, -1 };
        Node root = tree.buildTree(nodes);
        idx = -1;
        Node subRoot = tree.buildTree(node2);
        // System.out.println("Root is : "+root.data);
        // System.out.println("Diameter of the Tree is :
        // "+tree.treeDiameter2(root).diameter);

        // System.out.println(tree.isSubtree(root, subRoot) ? "Yes , a Subtree" : "No, not a Subtree");

        System.out.println();
        tree.topView(root);
    }
}