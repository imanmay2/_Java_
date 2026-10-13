#include<iostream>
#include<vector>
#include<climits>
#include<algorithm>

using namespace std;


const long long INF=1LL<<60; 

//function for floyd warshall algorithm.

void floyd(int V,vector<vector<long long>> &dist){
    for(int k=0;k<V;k++){
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(dist[i][k]==INF || dist[k][j]==INF){
                    continue;
                }
                dist[i][j]=min(dist[i][j],dist[i][k]+dist[k][j]);
            }
        }
    }
}

int main(){
    int V,E;
    cout<<"Enter V & E : "<<endl;
    cin>>V>>E;

    vector<vector<long long>> dist(V,vector<long long>(V,INF));

    for(int i=0;i<V;i++){
        dist[i][i]=0;
    }

    //take the inputs.
    for(int i=0;i<E;i++){
        int u,v,w;
        cout<<"enter : : "<<endl;
        cin>>u>>v>>w;
        dist[u][v]=min(dist[u][v],(long long)w);
    }

    floyd(V,dist);

    //print the dist.
    for(int i=0;i<V;i++){
        for(int j=0;j<V;j++){
            if(dist[i][j]==INF){
                cout<<"INF ";
            }else{
                cout<<dist[i][j]<<" ";
            }
        }
        cout<<endl;
    }

    //detect the negative edge.
    for(int i=0;i<V;i++){
        if(dist[i][i]<0){
            cout<<"-ve Edge.";
            return 0;
        }
    }

    return 0;
}