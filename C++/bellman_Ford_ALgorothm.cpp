#include<iostream>
#include<climits>
#include<vector>

using namespace std;
struct Edge{
    int src,dest,wt;
};

//write the bellman ford algorithm.
void bellman_ford(int V,vector<Edge> &edge,int src){
    vector<long long> dist(V,LLONG_MAX/4);

    dist[src]=0;
    

    for(int i=0;i<V-1;i++){
        for(int j=0;j<edge.size();j++){
            Edge e=edge[j];
            int u=e.src;
            int v=e.dest;
            int wt=e.wt;

            if(dist[u]!=LLONG_MAX/4 && dist[u]+wt<dist[v]){
                dist[v]=dist[u]+wt;
            }
        }
    }

    //check for the negative weight cycle.
    for(int j=0;j<edge.size();j++){
        Edge e=edge[j];
        int u=e.src;
        int v=e.dest;
        int wt=e.wt;

        if(dist[u]!=LLONG_MAX/4 && dist[u]+wt<dist[v]){
            cout<<"ENegative cyccle detected. ";
            return;
        }
    }

    //print the shortest distance
    for(int i=0;i<dist.size();i++){
        cout<<"DIstance from "<<src<<" to "<<i<<" is = "<< dist[i]<<endl;
    }
}

int main(){
    vector<Edge> edge;
    int V;
    cout<<"Enter the Vertex : "<<endl;
    cin>>V;

    int E;
    cout<<"Enter the edge : "<<endl;
    cin>>E;

    for(int i=0;i<E;i++){
        int u,v,w;
        cout<<"Enter u,v,w : "<<endl;
        cin>>u>>v>>w;

        edge.push_back({u,v,w});
    }

    int src;
    cout<<"Enter Src : "<<endl;
    cin>>src;

    bellman_ford(V,edge,src);
    return 0;
}