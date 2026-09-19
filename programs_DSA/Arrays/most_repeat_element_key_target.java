import java.util.ArrayList;

public class most_repeat_element_key_target {
    public static void main(String args[]){

        int[] num={2,1,2,1,2,3};
        ArrayList<Integer> res=new ArrayList<>();
        int key=1;
        for(int i=0;i<num.length;i++){
            if(num[i]==key){
                while(i<num.length-1){
                    i++;
                    res.add(num[i]);
                }
                break;
            }
        }
        ArrayList<Integer> countOfEachItem=new ArrayList<>();
        for(int i=0;i<res.size();i++){
            int count=0;
            for(int j=0;j<res.size();j++){
                if(res.get(j)==res.get(i)){
                    count++;
                }
            }
            countOfEachItem.add(count);
        }
        int max=countOfEachItem.get(0);
        int index=0;
        for(int i=0;i<countOfEachItem.size();i++){
            if(countOfEachItem.get(i)>max){
                max=countOfEachItem.get(i);
                index=i;
            }
        }
        System.out.println(res.get(index));
    }
}
