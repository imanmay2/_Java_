//  There are coordinates given. 
//  We need to find the nearest K cars nearby the origin.

import java.util.*;

public class nearbyCars{

    public static class Points implements Comparable<Points>{
        int x,y,dist;

        public Points(int x,int y,int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }

        @Override
        public int compareTo(Points p1){
            return this.dist-p1.dist;
        }
    }

    public static int calcDist(int x,int y){
        return (x*x)+(y*y);
    }

    public static void main(String args[]){
        PriorityQueue<Points> pq=new PriorityQueue<>();
        int arr[][]={{3,3},{5,-1},{-2,4}};
        int k=2;
        for(int i=0;i<arr.length;i++){
            int dist=calcDist(arr[i][0],arr[i][1]);
            pq.add(new Points(arr[i][0],arr[i][1],dist));
        }

        System.out.println("Nearest Cars present : ");
        int ct=0;
        while(!pq.isEmpty()){
            Points p1=pq.remove();
            System.out.println(p1.x+" , "+p1.y);
            ct++;
            if(ct==k){
                break;
            }
        }
    }
}