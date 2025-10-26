class Node{
    int data;
    Node left,right;
    public Node(int data){
        this.data=data;
        this.left=this.right=null;
    }
}


class BinaryTree{
    public static Node arr_BST(int arr[],int si,int ei){
        if(si>ei){
            return null;
        }

        int mid=(si+ei)/2;
        Node root=new Node(arr[mid]);

        root.left=arr_BST(arr, si, mid-1);
        root.right=arr_BST(arr, mid+1, ei);

        return root;
    }

    public static void preOrder(Node root){
        if(root==null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
}


public class sorted_arr_to_balancedBST {
    public static void main(String args[]){
        int arr[]={3,5,6,8,10,11,12};
        BinaryTree tree=new BinaryTree();
        Node root=tree.arr_BST(arr, 0, arr.length-1);
        tree.preOrder(root);

    }
}
