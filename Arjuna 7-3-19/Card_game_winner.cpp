#include<iostream>
#include<queue>
#include<string>
using namespace std;
int main(){
int n,temp;
cin>>n;
queue<int> q;
queue<int> q1;
for(int i=0;i<n;i++){
    cin>>temp;
    q.push(temp);
}
cin>>n;
for(int i=0;i<n;i++){
    cin>>temp;
    q1.push(temp);
}
string call;
cin>>call;
int c=0,c1=0;
while(!q.empty()){
    if(call=="Even"){
        c+=q.front()-q1.front();
        c1+=q1.front()-q.front();
        q.pop();q1.pop();
        call="Odd";
    }
    else if(call=="Odd"){
        q.pop();q1.pop();
        call="Even";
    }
}
if(c==c1) cout<<"Tie"<<endl;
else if(c>c1) cout<<"Andrea"<<endl;
else cout<<"Maria"<<endl;
}
