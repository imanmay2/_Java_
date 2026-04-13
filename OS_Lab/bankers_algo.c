#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
int main(){
    int n,m;
    n=5,m=3;
    int alloc[5][3]={{0,1,0},{2,0,0},{3,0,2},{2,1,1},{0,0,2}};
    int max[5][3]={{7,5,3},{3,2,2},{9,0,2},{4,2,2},{5,3,3}};
    int avail[]={3,3,2};
    int need[n][m];
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            need[i][j]=max[i][j]-alloc[i][j];
        }
    }
    

    int finish[n];
    for(int i=0;i<n;i++){
        finish[i]=0;
    }
    int count=0;
    int safeseq[n];
    while(count<n){
        int found=0;
        for(int i=0;i<n;i++){
            if(finish[i]==0){
                int j;
                for(j=0;j<m;j++){
                    if(need[i][j]>avail[j]){
                        break;
                    }
                }

                if(j==m){
                    for(int k=0;k<m;k++){
                        avail[k]+=alloc[i][k];
                    }
                    safeseq[count++]=i;
                    found=1;
                    finish[i]=1;
                }
            }
            

        }
        if(found==0){
                printf("The processes are not in safe seq\n");
                return 0;
            }
    }
    printf("The safe sequence is : \n");
    for(int i=0;i<n;i++){
        printf("P%d ",safeseq[i]);
    }
}