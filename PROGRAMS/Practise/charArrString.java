public class charArrString {
    public  static void main(String args[]){
        String str="Hello this is Java Tutorial";
        //printing the maximum largest string from the given sentence.
        String arr[]=str.split(" ");
        int maxPosition=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].length()>maxPosition){
                maxPosition=i;
            }
        }

        System.out.println("Largest String in the Sentence is: "+arr[maxPosition]);
        }
}