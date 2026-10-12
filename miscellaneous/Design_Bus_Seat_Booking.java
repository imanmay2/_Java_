class BusBooking {
    //build a 2D Array.
    public int arr[][];
    public int cost[][];

    //list format : index , index_to_check.
    HashMap<Character,List<Integer>> hm=new HashMap<>();
    int time=0;
    int s=0;

    public BusBooking(int n) {
        arr=new int[n][4];
        cost=new int[n][4];
        hm.put('A',Arrays.asList(0,1));
        hm.put('B',Arrays.asList(1));
        hm.put('C',Arrays.asList(2));
        hm.put('D',Arrays.asList(3,2));

        for(int i=0;i<n;i++){
            Arrays.fill(arr[i],0);
            Arrays.fill(cost[i],0);
        }
    }
    
    public void toggle(String seat){
        int row=(Integer.parseInt(seat.substring(1)))-1; //detects the row number from the string.
        char ch=seat.charAt(0);
        List<Integer> list=hm.get(ch);
        int col=list.get(0);

        //the seat is booked.
        if(arr[row][col]==1){
            // need to free the seat.
            arr[row][col]=0;
            s--;
            time=time-cost[row][col];
            cost[row][col]=0;
        }else{
            //seat is not booked.
            //need to book the seat.
            int c=1;
            if((ch=='A' || ch=='D') && arr[row][list.get(1)]==1){
                //yes adjancet is also booked. 
                c=3;
            }

            time=time+c;
            cost[row][col]+=c;
            arr[row][col]=1;
            s++;
        }
    }
    
    public int getTotalTime() {
        return time;
    }
    
    public int getMinTime() {
        return s;
    }
}

/**
 * Your BusBooking object will be instantiated and called as such:
 * BusBooking obj = new BusBooking(n);
 * obj.toggle(seat);
 * int param_2 = obj.getTotalTime();
 * int param_3 = obj.getMinTime();
 */