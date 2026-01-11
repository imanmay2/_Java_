public class Tries {

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
        for(int level=0;level<word.length();level++){
            int idx=word.charAt(level)-'a'; //index of the children array for tracking 
            if(curr.children[idx]==null){
                //insert the new node at that parrticular index. 
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }

    public static boolean search(String key){
        Node curr=root;
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }

        return curr.eow==true;
    }
    public static void main(String args[]){
        String words[]={"the","they","there","a","any","their","thee"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }


        System.out.println(search("thee"));
        System.out.println(search("th"));

    }
}
