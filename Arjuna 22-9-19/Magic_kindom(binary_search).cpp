#include<bits/stdc++.h>
using namespace std;
int m,n;
int chocolates(int** input,int r,int c,int val){
    if(r==m-1 && c==n-1 && val+input[r][c]>0) //if chocolates are not 0 
        return 1;
    if(r>=m || c>=n || val<=0) return 0;   //if chocolates are 0 
     return (chocolates(input,r+1,c,val+input[r][c]) || 
       chocolates(input,r,c+1,val+input[r][c])); //seeing the possible path
}
int main(){
    cin>>m>>n; //no. of rows and column
    int** arr=new int*[m];
    int l=1,h=INT_MAX,ans=0;
    for(int i=0;i<m;i++){
        arr[i]=new int[n];
        for(int j=0;j<n;j++){
            cin>>arr[i][j]; // chocolates in each of the compartment. 
        }
    }
    while(l<=h){
        int mid=(l+h)/2;
        if(chocolates(arr,0,0,mid)){
            h=mid-1;
            ans=mid;
        }
        else l=mid+1;
        }
    cout<<ans<<endl;     
}