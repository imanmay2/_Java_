#include<stdio.h>


int main(){
    int n=7;
    int arr[]={82,170,43,140,24,16,190};
    int head=50;
    int seek_time=head-arr[0];
    if(seek_time<0){
        seek_time=seek_time*(-1);
    }
    for(int i=0;i<n-1;i++){
        int sum=arr[i]-arr[i+1];
        if(sum<0){
            sum=sum*(-1);
        }
        seek_time=sum+seek_time;
    }

    printf("The Seek time : %d",seek_time);
}