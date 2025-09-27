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
        System.out.print(root.data+ " ");
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

    

    public static Node deleteNode(Node root,int key){
        if(root.data<key){
            root.right=deleteNode(root.right, key);
        }
        else if(root.data>key){
            root.left=deleteNode(root.left, key);
        } else{
            //case 1 - Node is having no children.
            if(root.left==null && root.right==null){
                return null;
            }

            //case -2 Node having exactly one 1 child.
            if(root.left==null){
                return root.right;
            }

            if(root.right==null){
                return root.left;
            }


            //case-3 where Node is having 2 children. 
            Node IS=findInorderSuccessor(root.right);
            root.data=IS.data;
            root.right=deleteNode(root.right, IS.data);
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }

        return root;
    }
    public static void main(String args[]){
        int values[]={8,5,3,1,4,6,10,11,14};
        Node root=null;
        for(int i=0;i<values.length;i++){
            root=buildBST(root, values[i]);
        }

        InOrderTraversal(root);
        System.out.println();
        deleteNode(root, 14);
        InOrderTraversal(root);
    }
}
