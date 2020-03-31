#include<iostream>
#include<queue>
#include<stack>
using namespace std;
int main(){
int n,f;
cin>>n>>f;
int cost[n][n];
for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cost[i][j]=0;    //Initially no path between any nodes
        }
	}
	for(int i=0;i<f;i++){
            int x,y,z;
            cin>>x>>y>>z;
            cost[x][y]=z;   //Formation of roadmap in form of graph
	}
int s,d,k1;
cin>>s>>d>>k1;
int level[n],visit[n],ct[n],count=0; //To keep track of shortest path and visited node
queue<int> q;
stack<int> s1;
for(int i=0;i<n;i++){
        level[i]=0;visit[i]=0;
        ct[i]=0;
}
int path[999],cost1[999];
for(int i=0;i<999;i++){
    path[i]=0;cost1[i]=0;
}
while(level[d]!=-1){
        int v=s;
for(int i=0;i<n;i++){
        level[i]=-1;visit[i]=0;
        ct[i]=0;
}
    q.push(v);
    s1.push(v);
    visit[v]=1;
    while(!q.empty()){
            v=q.front();
       for(int k=0;k<n;k++){
           if(cost[v][k]!=0&&visit[k]!=1){
              q.push(k);
              s1.push(k);
              level[k]=level[v]+1;
              visit[k]=1;
              ct[k]=ct[v]+cost[v][k];
              }
           }
       q.pop();
}
int c=0;
if(s1.top()!=s){
while(s1.top()!=d){
    s1.pop();
}
while(c!=level[d]){
    s1.pop();
    c+=1;
}
cost[s][s1.top()]=0;
while(!s1.empty()){
    s1.pop();
}
}
    cost1[count]=ct[d];
    path[count]=level[d];
count++;
}
int min=999999;
int flag=0;
for(int i=0;i<count-1;i++){
        if(path[i]<=k1 && cost1[i]<min){
            flag=1;
                min=cost1[i];
        }
}
if(flag==0) cout<<-1;
else cout<<min;
}
