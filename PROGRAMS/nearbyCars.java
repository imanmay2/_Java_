//  There are coordinates given. 
//  We need to find the nearest K cars nearby the origin.

import java.util.*;

public class nearbyCars{

    public class Points implements Comparable<Points>{
        int x,y,dist;

        public Points(int x,int y,int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }

        @Override
        public void compareTo(Points p1){
            return this.dist-p1.dist;
        }
    }

    public static int calcDist(int x,int y){
        return (x*x)+(y*y);
    }

    public static void main(String args[]){
        PriorityQueue pq=new PriorityQueue<>();
        int arr={{3,3},{5,-1},{-2,4}};
        int k=2;
        for(int i=0;i<arr.length;i++){
            int dist=calcDist(arr[i][0],arr[i][1]);
            pq.add(new Points(arr[i][0],arr[i][1],dist));
        }


        for(int i=0;i<k;i++){
            System.out.printf("%d , %d",pq[i].x,pq[i].y);

        }
    }
}