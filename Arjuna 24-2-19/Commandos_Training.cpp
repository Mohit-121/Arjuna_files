#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;
int main()
{
int m,n,f;      //m-players n-end point f-no of connections
cin >> m>>n>>f;
int cost[n+1][n+1],v;
for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            cost[i][j]=0;    //Initially no path between any nodes
        }
	}
	for(int i=0;i<f;i++){
            int x,y;
            cin>>x>>y;
            cost[x][y]=1;   //Formation of roadmap in form of graph
            cost[y][x]=1;   //1 specifices path between two nodes
	}
int maxi[m];
for(int p=1;p<=m;p++){
    v=p;
int level[n+1],visit[n+1]; //To keep track of shortest path and visited node
for(int i=1;i<=n;i++){
        level[i]=0;visit[i]=0;
}
    queue<int> q;
    q.push(v);
    visit[v]=1;
    while(!q.empty()){
            v=q.front();
       for(int k=1;k<=n;k++){
           if(cost[v][k]==1&&visit[k]!=1){
              q.push(k);
              visit[k]=1;
              level[k]=level[v]+1;
       }}
       q.pop();
}
maxi[p-1]=level[n];  //Adding shortest path of all the players(1-m) to reach destination(n)
}
int *l=max_element(maxi,maxi+m); //Maximum time taken to reach the destination
int count=0;
for(int i=0;i<m;i++){
if(maxi[i]==*l) count++;  //count no of players who reach at the maximum time
}
cout<<count<<endl;
}
