#include<iostream>
#include<queue>
using namespace std;
int main(){
int n,count=0;
cin>>n;
queue<int> q;
queue<int> q1;
for(int i=0;i<n;i++){
    int x;
    cin>>x;
    q1.push(x);
}
for(int i=0;i<n;i++){
    int x;
    cin>>x;
    q.push(x);
}
int ecount=0;
while(!q.empty()){
    if(ecount==q.size()) break;
    if(q1.front()==q.front()){
        ecount=0;
        q1.pop();
        q.pop();
    }
    else{
        int x=q.front();
        q.pop();
        q.push(x);
        ecount++;
    }
}
count=0;
while(!q.empty()){
    count++;
    q.pop();
}
cout<<count;
}
