public class binaryTree__2 {

    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class Info{
        int height;
        int diameter;
        public Info(int height,int diameter){
            this.height=height;
            this.diameter=diameter;
        }
    }

    static class BinaryTree2{
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }

        public static int height(Node root){
            if(root==null){
                return 0;
            }
            int left=height(root.left);
            int right=height(root.right);
            return Math.max(left,right)+1;
        }

        public static int treeDiameter(Node root){
            if(root==null){
                return 0;
            }
            int lh=height(root.left);
            int rh=height(root.right);
            int ld=treeDiameter(root.left);
            int rd=treeDiameter(root.right);
            return Math.max(Math.max(ld,rd),(lh+rh+1));
        }


        public static Info treeDiameter2(Node root){
            if(root==null){
                return new Info(0,0);
            }

            Info leftInfo=treeDiameter2(root.left);
            Info rightInfo=treeDiameter2(root.right);

            int diameter=Math.max(Math.max(leftInfo.diameter,rightInfo.diameter),leftInfo.height+rightInfo.height+1);
            int height=Math.max(leftInfo.height,rightInfo.height)+1;
            return new Info(height,diameter);
        }

        public static boolean isSubtree(Node root,Node subroot){
            //base case.
            if(root==null){
                return false;
            }

            if(root.data==subroot.data){
                if(isIdentical(root,subroot)){
                    return true;
                }
            }

            return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
        }

        public static boolean isIdentical(Node root,Node subroot){
            if(root==null && subroot==null){
                return true;
            } else if(root==null || subroot==null ||root.data!=subroot.data){
                return false;
            } else if(!isIdentical(root.left, subroot.left)){
                return false;
            }else if(!isIdentical(root.right, subroot.right)){
                return false;
            }
        }
    }
    public static void main(String args[]){
        BinaryTree2 tree=new BinaryTree2();
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root=tree.buildTree(nodes);
        System.out.println("Root is : "+root.data);
        System.out.println("Diameter of the Tree is : "+tree.treeDiameter2(root).diameter);
    }
}