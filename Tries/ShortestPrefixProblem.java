public class ShortestPrefixProblem {

    static class Node{
        Node children[] = new Node[26];
        int freq=-1;

        public Node(){
            for(int i=0;i<children.length;i++){
                children[i]=null;
            }
        }
    }

    public static Node root=new Node();


    public static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
                curr.children[idx].freq=1;
            }else{
                curr.children[idx].freq++;
            }
            curr=curr.children[idx];
        }
    }

    public static void findPrefix(Node root,String ans){
        if(root==null){
            return;
        }


        if(root.freq==1){
            System.out.println(ans+" ");
            return;
        }

        for(int i=0;i<root.children.length;i++){
            if(root.children[i]!=null){
                
                findPrefix(root.children[i], ans+(char)('a'+i));
            }
        }
    }


    public static void main(String args[]){
        String words[]={"zebra","dog","duck","dove"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        findPrefix(root,"");
    }
}