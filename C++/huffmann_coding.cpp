#include<iostream>
#include<vector>
#include<algorithm>
#include<map>
using namespace std;

class Node{
    public: 
    int freq;
    char ch;
    Node* left;
    Node* right;
    Node(char c,int f){
        ch=c;
        freq=f;
        left=NULL;
        right=NULL;
    }
};

class Comparable{
    public:
    bool operator()(Node* a,Node* b){
        return a->freq > b->freq;
    }
};

void generateCode(Node *root,string str,unordered_map<char,string> &map){
    if(root==NULL){
        return;
    }

    if(root->left==NULL && root->right==NULL){
        map[root->ch]=str;
    }

    generateCode(root->left,str+"0",map);
    generateCode(root->right,str+"1",map);

}

int main(){
    int n;
    cout<<"Enter range : "<<endl;
    cin>>n;

    vector<char> arr(n);
    vector<int> arr2(n);

    for(int i=0;i<n;i++){
        cout<<"Enter : ";
        cin>>arr[i];
        cin>>arr2[i];
    }

    priority_queue<Node*,vector<Node*>,Comparable> pq;
    //insert all the pair in the pq for getting sorted.

    for(int i=0;i<n;i++){
        pq.push(new Node(arr[i],arr2[i]));
    }

    // doing the main operations now.
    while(pq.size() > 1){
        Node* left=pq.top();
        pq.pop();

        Node* right=pq.top();
        pq.pop();

        Node* merge=new Node('$',(left->freq+right->freq));
        merge->left = left;
        merge->right = right;
        pq.push(merge);
    }

    Node* root=pq.top();
    string str="";
    unordered_map<char,string> map_;
    generateCode(root,str,map_);


    for(int i=0;i<n;i++){
        cout<<arr[i]<<" --> "<<map_[arr[i]]<<endl;
    }
}