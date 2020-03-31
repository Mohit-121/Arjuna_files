#include<iostream>
using namespace std;
int main(){
int n;
cin>>n;
int arr[n],count[n],result[n];
for(int i=0;i<n;i++){
        cin>>arr[i];
        count[i]=0;
result[i]=-1;
}
for(int i=0;i<n;i++){
    count[arr[i]]++;
}
int m=-1;
for(int i=0;i<n-1;i++){
         m=-1;
    for(int j=i+1;j<n;j++){
        if(count[arr[j]]>count[arr[i]]){
            m=arr[j];
            break;
        }
    }
        result[i]=m;
}
for(int i=0;i<n;i++) cout<<result[i]<<" ";
}



