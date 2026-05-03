public class Min_Max_Query_SegmentTree {
    static int arr[]={6,8,-1,2,17,1,3,2,4};
    static int tree[]=new int[4*arr.length];

    public static void printTree(int tree[]){
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }
    }
    public static void buildTree(int i,int si,int ei){
        if(si==ei){
            tree[i]=arr[si];
            return;
        }
        int mid=(si+ei)/2;
        buildTree(2*i+1, si, mid);
        buildTree(2*i+2, mid+1, ei);
        tree[i]=Math.max(tree[2*i+1],tree[2*i+2]);
    }

    public static int findMaxSubArray(int i,int si,int sj,int qi,int qj){
        //non overlapping case
        if(sj<qi || qj<si){
            return Integer.MIN_VALUE;
        }

        //overlapping case
        if(si>=qi && sj<=qj){
            return tree[i];
        }

        //partial overlapping case
        int mid=(si+sj)/2;
        int left=findMaxSubArray(2*i+1,si, mid, qi, qj);//left tree
        int right=findMaxSubArray(2*i+2, mid+1, sj, qi, qj);//right tree
        return Math.max(left,right);
    }

    public static void updateQueryUtil(int i,int idx,int newval,int si,int ei){
        if(idx<si || idx>ei){
            return;
        }
        tree[i]=Math.max(tree[i],newval);
        if(si!=ei){
            int mid=(si+ei)/2;
            updateQueryUtil(2*i+1, idx, newval, si, mid);
            updateQueryUtil(2*i+2, idx, newval, mid+1, ei);
        }
    }

    public static void updateQuery(int idx,int newval){
        arr[idx]=newval;
        System.out.println("Tree updated...");
        updateQueryUtil(0, idx, newval,0 , arr.length-1);
    }
    public static void main(String args[]){
        buildTree(0, 0, arr.length-1);
        // printTree(tree);
        System.out.println("The Maximum is : "+findMaxSubArray(0, 0, arr.length, 2, 5));
        updateQuery(3, 20);
        System.out.println("The Maximum is : "+findMaxSubArray(0, 0, arr.length, 2, 5));
        printTree(tree);

    }
}
