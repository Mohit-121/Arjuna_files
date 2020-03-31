#include<iostream>
#include<queue>
using namespace std;
int main(){
int n,f;
cin>>n>>f;
int cost[n+1][n+1],v=1;
for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            cost[i][j]=0;    //Initially no path between any nodes
        }
	}
	for(int i=0;i<f;i++){
            int x,y,z;
            cin>>x>>y>>z;
            cost[x][y]=z;   //Formation of roadmap in form of graph
            cost[y][x]=z;   //1 specifices path between two nodes
	}
int p,k1;
cin>>p>>k1;
int level[n+1],visit[n+1];
for(int i=1;i<=n;i++){
        level[i]=0;visit[i]=0;
}
for(int i=1;i<=n;i++){
    for(int j=1;j<=n;j++){
        if(cost[i][j]>k1){
            cost[i][j]=0;
        }
    }
}
int arr[p];
for(int i=0;i<p;i++){
    int x;
    cin>>x;
    arr[i]=x;
    visit[x]=1;
}
int count=0;
count+=p;
for(int i=0;i<p;i++){
queue<int> q;
    q.push(arr[i]);
    v=arr[i];
    visit[v]=1;
    while(!q.empty()){
            v=q.front();
       for(int k=1;k<=n;k++){
           if(cost[v][k]!=0&&visit[k]!=1){
                count++;
                visit[k]=1;
              q.push(k);
              }
       }
       q.pop();
}
}
cout<<count<<endl;
}
