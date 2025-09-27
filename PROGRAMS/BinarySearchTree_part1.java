public class BinarySearchTree_part1 {

    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }

    public static void InOrderTraversal(Node root){
        if(root==null){
            return;
        }

        InOrderTraversal(root.left);
        System.out.println(root.data+ " ");
        InOrderTraversal(root.right);
    }

    public static Node buildBST(Node root,int val){
        //base case
        if(root==null){
            root=new Node(val);
            return root;
        }

        if(root.data>val){
            root.left=buildBST(root.left, val);
        } else{
            root.right=buildBST(root.right, val);
        }
        return root;
    }

    public static boolean searchBST(Node root, int key){
        if(root==null){
            System.out.println(key+" is not present in the Binary Tree.");
            return false;
        }

        if(root.data==key){
            System.out.println(key+" is present in the Binary Tree.");
            return true;
        }else if(root.data>key){
            searchBST(root.left, key);
        }else{
            searchBST(root.right, key);
        }
        return true;
    }
    public static void main(String args[]){
        int values[]={5,1,3,4,2,7};
        Node root=null;
        for(int i=0;i<values.length;i++){
            root=buildBST(root, values[i]);
        }

        System.out.println("Inorder Traversal of the BST : ");
        InOrderTraversal(root);

        searchBST(root, 9);
    }
}
