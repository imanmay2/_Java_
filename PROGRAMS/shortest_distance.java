// Given a route of 4 directions(N,S,E,W) , find the shortest path to reach the destination.

import java.util.*;
public class shortest_distance{
    public static void main(String args[]){
        String str="WNEENESENNN";
        int y=0;
        int x=0;
        for(int i=0;i<str.length();i++){
            char s=str.charAt(i);
            if(s=='N'){
                y++;
            }
            else if(s=='S'){
                y--;
            }
            else if(s=='E'){
                x++;
            }
            else if(s=='W'){
                x--;
            }
        }
        double shortest=Math.sqrt((x*x)+(y*y));
        System.out.print("The shortest Distance is : "+ shortest);
    }
}