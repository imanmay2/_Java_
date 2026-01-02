
import java.util.LinkedList;

public class Hashing{

    public static class HashMap<K,V>{
        public class Node{
            K key;
            V value;
            public Node(K key,V value){
                this.key=key;
                this.value=value;
            }
        }

        private LinkedList<Node> bucket[];
        private int N;
        private int n;

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N=4;
            this.n=0;
            this.bucket=new LinkedList[4];
            for(int i=0;i<N;i++){
                this.bucket[i]=new LinkedList<Node>();
            }
        }

        private int hashFunc(K key){
            int idx=key.hashCode();
            return idx%N;
        }

        private int searchLL(int bi,K key){
            int di=0;
            for(int i=0;i<bucket[bi].size();i++){
                if(bucket[bi].get(i).key==key){
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehashing(){
            LinkedList[] oldBucket=bucket;
            N=N*2;
            bucket=new LinkedList[N];

            // re-initializing the Bucket.
            for(int i=0;i<N;i++){
                bucket[i]=new LinkedList<Node>();
            }

            for(int i=0;i<oldBucket.length;i++){
                LinkedList<Node> ll=bucket[i];
                for(int j=0;j<ll.size();j++){
                    Node node=ll.get(j);
                    put(node.key,node.value);
                }
            }
        }

        public void put(K key,V value){
            int bi=hashFunc(key);
            int di=searchLL(bi,key);

            if(di==-1){
                bucket[bi].add(new Node(key,value));
                n++;
            }else{
                bucket[bi].get(di).value=value;
            }

            //rehashing concept.
            double lamda=(double)n/N;
            if(lamda>2.0){
                rehashing();
            }
        }


        public K remove(K key){
            int bi=hashFunc(key);
            int di=searchLL(bi,key);

            if(di==-1){
                return null;
            }else{
                Node node=bucket[bi].remove(di);
                n--;
                return node.key;
            }   
        }

        public V get(K key){
            int bi=hashFunc(key);
            int di=searchLL(bi,key);

            if(di==-1){
                return null;
            }else{
                Node node=bucket[bi].get(di);
                return node.value;
            }   
        }

        public void printHM(){
            for(int i=0;i<N;i++){
                LinkedList<Node> ll=bucket[i];
                for(int j=0;j<ll.size();j++){
                    System.out.print(ll.get(j).key +" : "+ ll.get(j).value);
                }
            } System.out.println();
        }
    }

    public static void main(String args[]){
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("Germany",100);
        hm.put("India",50);
        hm.put("Netherlands",48);

        hm.printHM();
        System.out.println(hm.remove("India"));
        hm.printHM();
        
    }
}