import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BinaryTree {
    public static Node arr_BST(int arr[], int si, int ei) {
        if (si > ei) {
            return null;
        }

        int mid = (si + ei) / 2;
        Node root = new Node(arr[mid]);

        root.left = arr_BST(arr, si, mid - 1);
        root.right = arr_BST(arr, mid + 1, ei);

        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    public static void BST_to_Balanced_BST(Node root1) {
        // step: 1 to convert the BST to inOrder array.

        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root1, list);
        int arr[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        // step :2 to conver the inOrder sorted array to BST.
        Node root = arr_BST(arr, 0, arr.length - 1);

        preOrder(root);
    }
}

public class binaryTree_part_2 {
    public static void main(String args[]) {
        int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
        BinaryTree tree = new BinaryTree();
        // Node root=tree.arr_BST(arr, 0, arr.length-1);
        // tree.preOrder(root);

        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        tree.BST_to_Balanced_BST(root);
    }
}
