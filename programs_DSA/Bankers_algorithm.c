#include<stdio.h>

void inputArr(int n,int m,int arr[n][m]){
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            printf("Enter the element (%d,%d): ",i,j);
            scanf("%d",&arr[i][j]);
        }
    }
}

void printArr(int n,int m,int arr[n][m]){
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            printf("%d ",arr[i][j]);
        }
        printf("\n");
    }
}


int main(){
    int n=5;
    int m=3;
    int alloc[n][m];
    int max[n][m];
    int avail[m];
    int need[n][m];
    int finish[n];
    int sum[m];
    int total[]={10,5,7};
    inputArr(n,m,alloc);
    inputArr(n,m,max);

    printf("allocation Matrix is : \n");
    printArr(n,m,alloc);
    printf("Max_need matrix is : \n");
    printArr(n,m,max);

    //calculation of the available matrix. 
    for(int j=0;j<m;j++){
        int sum[j]=0;
        for(int i=0;i<n;i++){
            sum[j]+=alloc[i][j];
        }
    }
    for(int j=0;j<m;j++){
        avail[j]=total[j]-sum[j];
    }

    //calculation of the remaining matrix
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            need[i][j]=alloc[i][j]-max[i][j];
        }
    }
    printf("Remaining matrix is : \n");
    printArr(n,m,need);


    //bankers algo
    int safeSeq[n];
    int ct=0;
    while(ct<n){
        found=0;
        for(int i=0;i<n;i++){
            bool canExec=true;

            for(int j=0;j<m;j++){
                if(need[i][j]>avail[i][j]){
                    canExec=false;
                    break;
                }
            }

            if(canExec){
                for(int j=0;j<m;j++){
                    avail[i][j]=alloc[i][j]+avail[i][j];
                }
                found=1;
                safeSeq[ct++]=i;
                finish[i]=1;    
            }
                    
        }
        if(found==0){
            printf("deadlock");
            return;
        }
    }
    
}