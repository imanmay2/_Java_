public class Segment_Tree{

    static int arr[]={1,2,3,4,5,6,7,8};
    static int tree[]=new int[4*arr.length];

    public static void printTree(int tree[]){
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }
    }

    public static int query_sum(int i,int si,int sj,int qi,int qj){
        //base case
        if(sj<qi || qj<si){
            //non-overlapping
            return 0;
        }
        if(qi<=si && sj<=qj){
            //overlapping case
            return tree[i];
        }
        else{
            //partial overlapping case
            int mid=(si+sj)/2;
            int left=query_sum(2*i+1, si,mid, qi, qj);
            int right=query_sum(2*i+2, mid+1,sj, qi, qj);
            return left+right;
        }
    }

    public static void updateUtil(int i,int si,int sj,int idx,int diff){
        if(idx<si || sj<idx){
            return;
        }

        tree[i]+=diff;
        if(si!=sj){
            //branch into 2 as not leaf node
            int mid=(si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, diff);
            updateUtil(2*i+2, mid+1, sj, idx, diff);
        }
    }
    public static void updateQuery(int arr[],int i,int idx,int newval,int si,int sj){
        int diff=newval-arr[idx];
        arr[idx]=newval;
        updateUtil(i, si, sj, idx, diff);
        System.out.println("Query Updated");
    }

    public static void buildTree(int arr[],int sti,int start,int end){
        //base case
        if(start==end){
            tree[sti]=arr[start];
            return;
        }

        int mid=(start+end)/2;
        buildTree(arr, 2*sti+1, start,mid); //caling for the left subtree.
        buildTree(arr, 2*sti+2, mid+1, end); //calling for the right subtree.
        tree[sti]=tree[2*sti+1]+tree[2*sti+2];
        return;
    }
    public static void main(String args[]){
        buildTree(arr, 0, 0, arr.length-1);
        // printTree(tree);
        System.out.println(query_sum(0, 0, arr.length-1, 2, 5));
        updateQuery(arr, 0, 2, 2, 0, arr.length-1);
        System.out.println(query_sum(0, 0, arr.length-1, 2, 5));
    }
}