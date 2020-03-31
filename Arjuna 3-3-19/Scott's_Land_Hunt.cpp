#include<iostream>
using namespace std;
int main(){
int r,c;
cin>>r>>c;
int a[r][c];
for(int i=0;i<r;i++){
    for(int j=0;j<c;j++){
        cin>>a[i][j];
    }
}
int temp[r+1][c+1];
for(int i=0;i<r+1;i++){
    for(int j=0;j<c+1;j++){
        temp[i][j]=0;
    }
}
for(int i=0;i<r;i++){
   for(int j=0;j<c;j++){
    if((a[i][j])==1){
        int l=min(temp[i][j],temp[i][j+1]);
        temp[i+1][j+1]=min(l,temp[i+1][j])+1;
    }
   }
}
for(int i=0;i<r+1;i++){
    for(int j=0;j<c+1;j++){
        cout<<temp[i][j]<<" ";
    }
    cout<<endl;
}
int m=0;
for(int i=0;i<r+1;i++){
    for(int j=0;j<c+1;j++){
            if(temp[i][j]>m) m=temp[i][j];
    }}
cout<<m<<endl;
}
