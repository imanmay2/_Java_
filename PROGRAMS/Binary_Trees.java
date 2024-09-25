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
                System.out.println("-1 ");
            }
            System.out.println(root.data+" ");
            pre_order_Traversal(root.left);
            pre_order_Traversal(root.right);
        }
    }

    



    public static void main(String args[]){
        int[] arr={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root=binaryTree.buildTree(arr);
        System.out.println(root.data);
    }
}
