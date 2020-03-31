#include<iostream>
using namespace std;
int main(){
int n;
cin>>n;
int a[n];
for(int i=0;i<n;i++) cin>>a[i];
int count=0,k=0,count1=1;
while(count1!=count){
    int k=0,flag=0;
    count1=count;
    while(k<(n-1)){
    if(a[k]<a[k+1]){
    if(flag==0){
    count++;}
    swap(a[k],a[k+1]);
    k=k+2;
    flag=1;
    }
    else k=k+1;
    }}
cout<<count<<endl;
}