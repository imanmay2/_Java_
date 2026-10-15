#include<iostream>
#include<queue>
#include<algorithm>
#include<climits>


using namespace std;
int n;
int par[100];
int cap[100][100];
bool vis[100];

bool bfs(int s,int t){
    fill(vis,vis+n,false);
    
    queue<int> q1;
    q1.push(s);
    par[s]=-1;
    vis[s]=true;

    while(!q1.empty()){
        //remvoe the current
        int u=q1.front();
        q1.pop();
        
        for(int v=0;v<n;v++){
            if(!vis[v] && cap[u][v]>0){
                par[v]=u;
                vis[v]=true;
                q1.push(v);

                if(v==t){
                    return true;
                }
            }
        }
    }
    return false;
}

int edmond_karp(int s,int t){
    int maxFlow=0;
    while(bfs(s,t)){
        int flow=INT_MAX;
        for(int v=t;v!=s;v=par[v]){
            int u=par[v];
            flow=min(flow,cap[u][v]);
        }

        for(int v=t;v!=s;v=par[v]){
            int u=par[v];
            cap[u][v]-=flow;
            cap[v][u]+=flow;
        }

        maxFlow+=flow;
    }
    return maxFlow;
}

using namespace std;

int main(){
    n = 4;

    cap[0][1] = 3;
    cap[0][2] = 2;
    cap[1][2] = 1;
    cap[1][3] = 2;
    cap[2][3] = 3;

    int source = 0;
    int sink = 3;

    cout<<edmond_karp(source,sink)<<endl;
}