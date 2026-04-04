
public class CountUniqueSubstring_Trie{

    static class Node{
        Node children[]=new Node[26];
        boolean eow;

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
            }
            curr=curr.children[idx];
            
        } curr.eow=true;
    }

    public static int countNode_Trie(Node root){
        if(root==null){
            return 0;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count=count+countNode_Trie(root.children[i]);
            }
        }
        return count+1;
    }

    public static void subString(String word){
        for(int i=0;i<word.length();i++){
            insert(word.substring(i));
        }

        
    }
    public static void main(String args[]){
        subString("ababa");
        System.out.println(countNode_Trie(root));
    }
}