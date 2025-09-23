import java.util.ArrayList;

public class basic_BinaryTree {

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

    static class Info{
        int diam;
        int ht;
        public Info(int diam,int ht){
            this.diam=diam;
            this.ht=ht;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildBinaryTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left=buildBinaryTree(nodes); // calling the left subtree.
            newNode.right=buildBinaryTree(nodes); // calling the right subtree.

            return newNode;
        }

        public static int treeHeight(Node root) {
            // base case
            if (root == null) {
                return 0;
            }

            int leftHeight = treeHeight(root.left);
            int rightHeight = treeHeight(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }

        public static int treeDiameter(Node root) {
            if (root == null) {
                return 0;
            }


            int leftHeight = treeHeight(root.left);
            int rightHeight = treeHeight(root.right);


            int leftDiam = treeDiameter(root.left);
            int rightDiam = treeDiameter(root.right);

            int diam = leftHeight + rightHeight + 1;
            return Math.max(Math.max(leftDiam, rightDiam), diam);

        }

        public static Info treeDiameter_(Node root){

            if(root==null){
                return new Info(0,0);
            }

            Info leftInfo=treeDiameter_(root.left);
            Info rightInfo=treeDiameter_(root.right);
            int diam=Math.max(Math.max(leftInfo.diam, rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
            int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;
            return new Info(diam,ht);
        }

        public static void kthLevelTree(Node root,int k,int level){
            if(root==null){
                return;
            }

            if(k==level){
                System.out.print(root.data+" ");
                return;
            }

            kthLevelTree(root.left, k, level+1);
            kthLevelTree(root.right, k, level+1);
        }

        public static boolean getPath(Node root,int n,ArrayList<Node> path){

            if(root==null){
                return false;
            }

            path.add(root);

            if(root.data==n){
                return true;
            }
            boolean foundLeft=getPath(root.left, n, path);
            boolean foundRight=getPath(root.right, n, path);

            if(foundLeft || foundRight){
                return true;
            }

            path.remove(root);

            return false;
        }


        public static int LCA(Node root,int n1,int n2){
            ArrayList<Node> path1=new ArrayList<>();
            ArrayList<Node> path2 =new ArrayList<>();

            getPath(root,n1,path1);
            getPath(root,n2,path2);

            int findSmall=(path1.size()<path2.size()?path1.size():path2.size());
            int i;
            for(i=0;i<findSmall;i++){
                if(path1.get(i)!=path2.get(i)){
                    break;
                }
            }
            return path1.get(i-1).data;
        }

        public static Node LCA2(Node root,int n1,int n2){
            if(root==null || root.data==n1 || root.data==n2){
                return root;
            }



            Node leftRoot=LCA2(root.left, n1, n2);
            Node rightRoot=LCA2(root.right, n1, n2);

            if(leftRoot==null){
                return rightRoot;
            } 
            if(rightRoot==null){
                return leftRoot;
            }

            return root;
        }


        public static int calcMinDist(Node root,int n){
            if(root==null){
                return -1;
            }

            if(root.data==n){
                return 0;
            }


            int leftDist=calcMinDist(root.left, n);
            int rightDist=calcMinDist(root.right, n);

            if(leftDist==-1 && rightDist==-1){
                return -1;
            } else if(rightDist==-1){
                return leftDist+1;
            } else if(leftDist==-1){
                return rightDist+1;
            }
            return 0;
        }


        public static int minDistNode(Node root,int n1,int n2){
            Node lca=LCA2(root, n1, n2);

            int dist1=calcMinDist(lca,n1);
            int dist2=calcMinDist(lca,n2);

            return dist1+dist2;
        }
    }

    public static void main(String args[]) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(nodes);
        System.out.println("Root of the Tree : " + root.data);
        System.out.println();

        System.out.println("Diameter of the tree is : " + tree.treeDiameter(root));

        System.out.println();

        System.out.println("Diamter of the tree using O(n) : "+ tree.treeDiameter_(root).diam);


        System.out.println("The kth traversal nodes are : ");
        tree.kthLevelTree(root,3,1);

        System.out.println();

        System.out.println("Lowest Commn Ancestor is as follows : "+tree.LCA2(root, 4,5).data);


        System.out.println("Minimum distance Node is : "+tree.minDistNode(root, 4, 5));
    }
}
