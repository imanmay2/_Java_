#include<iostream>
using namespace std;

void subset(string str,string ans,int i){
    //base case
    if(i==str.length()){
        if(ans==""){
            cout<<"NULL ";
        }else{
            cout<<ans<<" ";
        }
        return;
    }

    //take the character
    subset(str,ans+str[i],i+1);
    //don't take the string
    subset(str,ans,i+1);
}

int main(){
    string str;
    cout<<"Enter the string : "<<endl;
    cin>>str;

    // string ans="";
    subset(str,"",0);
    return 0;
}