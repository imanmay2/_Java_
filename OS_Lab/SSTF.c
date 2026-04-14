#include<stdio.h>
#include<stdlib.h>
int main(){
    int n=7;
    int finish[n];
    for(int i=0;i<n;i++){
        finish[i]=0;
    }


    int arr[]={82,170,43,140,24,16,190};
    int head=50;
    int time=0;
    int vis[n];
    for(int i=0;i<n;i++){
        vis[i]=0;
    }
    for(int i=0;i<n;i++){
         int idx=-1;
    int min=10000;
        for(int j=0;j<n;j++){
            if(!vis[j]){
                int dist=abs(head-arr[j]);
                if(dist<min){
                    min=dist;
                    idx=j;
                }
            }
        }
        vis[idx]=1;
        time+=min;
        head=arr[idx];
        printf("%d -> ",idx);
    }
    printf("Total SSTF time. : %d ",time);
}