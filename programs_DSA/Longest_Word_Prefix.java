public class Longest_Word_Prefix {
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;

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
        }
        curr.eow=true;
    }

    public static String str_f=new String();

    public static void traverseTrie(Node root,StringBuilder sb){
        if(root==null){
            return;
        }

        
        for(int i=0;i<26;i++){
            if(root.children[i]!=null && root.children[i].eow){
                //find the character and append in the temp str.
                char ch=(char)('a'+i);
                sb.append(ch);

                if(sb.length()>str_f.length()){
                    str_f=sb.toString();
                }
                traverseTrie(root.children[i], sb);
                sb.deleteCharAt(sb.length()-1);
            } 
        }
    }
    
    public static void main(String args[]){
        String words[]={"a","banana","app","appl","ap","apply","apple"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }

        traverseTrie(root,new StringBuilder());
        System.out.println("Longest Prefix word is  "+str_f);
    }
}