#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;


int cross(vector<int> arr,int low,int mid,int high){
    int sum=INT_MIN;
    int leftSum=0;
    for(int i=mid;i>=low;i--){
        sum=sum+arr[i];
        leftSum=max(sum,leftSum);
    }

    sum=INT_MIN;
    int rightSum=0;
    for(int i=mid+1;i<=high;i++){
        sum=sum+arr[i];
        rightSum=max(sum,rightSum);
    }

    return leftSum+rightSum;
}

int maxSubArray(vector<int> arr,int low,int high){

    //base case
    if(low==high){
        return arr[low];
    }
    int mid=low+(high-low)/2;
    int left=maxSubArray(arr,low,mid);
    int right=maxSubArray(arr,mid+1,high);
    int c=cross(arr,low,mid,high);
    return max({left,right,c});
}

int main(){
    int n;
    cout<<"Enter the range for the array : "<<endl;
    cin>>n;
    
    vector<int> arr(n);
    for(int i=0;i<n;i++){
        cout<<"Enter Element : ";
        cin>>arr[i];
    }

    cout<<"Maximum SubArray Sum : "<<maxSubArray(arr,0,n-1)<<endl;
    
}