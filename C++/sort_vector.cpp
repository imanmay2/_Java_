#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

void print(vector<vector<int>> arr){
    for(int i=0;i<arr.size();i++){
        for(int j=0;j<arr[0].size();j++){
            cout<<arr[i][j]<<" ";
        }
        cout<<endl;
    }
}
int main(){
    vector<int> start_={1,3,0,5,8,5};
    vector<int> end_={2,4,6,9,9,7};
    vector<vector<int>> arr(6,vector<int>(2));
    for(int i=0;i<arr.size();i++){
        arr[i][0]=start_[i];
        arr[i][1]=end_[i];
    }

    print(arr);
    sort(arr.begin(),arr.end(),[](vector<int> &a,vector<int> &b){
        return a[1]<b[1];
    });

    print(arr);
}