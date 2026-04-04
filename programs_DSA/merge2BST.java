import java.util.*;

class Node{
    int data;
    Node left,right;

    public Node(int data){
        this.data=data;
        this.left=this.right=null;
    }
}

class BinaryTree{

    public static void inOrder(Node root,ArrayList<Integer> list){
        if(root==null){
            return;
        }

        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);

    }

    public static void preOrder(Node root){
        if(root==null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node balanceBST(ArrayList<Integer> list,int si,int ei){
        if(si>ei){
            return null;
        }

        int mid=(si+ei)/2;

        Node root=new Node(list.get(mid));
        root.left=balanceBST(list, si, mid-1);
        root.right=balanceBST(list, mid+1,ei);

        return root;
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> list1,ArrayList<Integer> list2){
        int i=0;
        int j=0;

        ArrayList<Integer> list3=new ArrayList<>();
        
        while(i<list1.size() && j<list2.size()){
            if(list1.get(i)<list2.get(j)){
                list3.add(list1.get(i));
                i++;
            }

            else{
                list3.add(list2.get(j));
                j++;
            }
        }

        while(i<list1.size()){
            list3.add(list1.get(i));
            i++;
        }

        while(j<list2.size()){
            list3.add(list2.get(j));
            j++;
        }

        return list3;



    }



    public static void mergeBST(Node root1,Node root2){
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        inOrder(root1, list1);
        inOrder(root2, list2);
        ArrayList<Integer> list3=merge(list1, list2);
        System.out.println(list3);

        Node root=balanceBST(list3, 0,list3.size()-1);


        preOrder(root);


    }
}

public class merge2BST {


    public static void main(String args[]){
        Node root1=new Node(2);
        root1.left=new Node(1);
        root1.right=new Node(4);

        Node root2=new Node(9);
        root2.left=new Node(3);
        root2.right=new Node(12);

        BinaryTree tree=new BinaryTree();
        tree.mergeBST(root1,root2);
    }
}
