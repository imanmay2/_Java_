#include<iostream>
#include<climits>
#include<algorithm>

using namespace std;
int cap[100][100];
int par[100];
int n;
bool vis[100];
bool dfs(int u,int t){
    vis[u]=true;
    if(u==t){
        return true;
    }
    for(int v=0;v<n;v++){
        if(!vis[v] && cap[u][v]>0){
            par[v]=u;
            if(dfs(v,t)){
                return true;
            }
        }
    }
    return false;
}

int ford_fulkerson(int s,int t){
    
    int maxFlow=0;
    
    while(true){
        fill(vis,vis+n,false);
        if(!dfs(s,t)){
            break;
        }

        int flow=INT_MAX;
        for(int v=t;v!=s;v=par[v]){
            int u=par[v];
            flow=min(flow,cap[u][v]);
        }

        //fill the residual.
        for(int v=t;v!=s;v=par[v]){
            int u=par[v];
            cap[u][v]-=flow;
            cap[v][u]+=flow;
        }
        maxFlow+=flow;
    }
    return maxFlow;
}

int main(){
    n = 4;
    cap[0][1] = 3;
    cap[0][2] = 2;
    cap[1][2] = 1;
    cap[1][3] = 2;
    cap[2][3] = 3;
    int source = 0;
    int sink = 3;
    cout<<ford_fulkerson(source,sink)<<endl;
}