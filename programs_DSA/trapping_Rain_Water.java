public class trapping_Rain_Water {


    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    public static int calcLeftMax(int[] arr,int k){
        int max=0;
        for(int i=0;i<=k;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    public static int calcRightMax(int[] arr,int k){
        int max=0;
        for(int i=k;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }

        return max;
    }

    public static void main(String args[]){
        int[] arr={4,2,0,6,3,2,5};
        int width=1;   // width of each of the building.
        int[] leftMaxArr=new int[arr.length];
        int[] rightMaxArr=new int[arr.length];


        for(int i=0;i<arr.length;i++){
            leftMaxArr[i]=calcLeftMax(arr, i);
            rightMaxArr[i]=calcRightMax(arr, i);
        }

        // print(leftMaxArr);
        // print(rightMaxArr);

        int area=0;
        for(int i=0;i<arr.length;i++){
            int min=leftMaxArr[i]>rightMaxArr[i]?rightMaxArr[i]:leftMaxArr[i];

            area=area+(min-arr[i])*width;
        }


        System.out.print("The maximum area trapped inside the building is: "+area);

    }
}
