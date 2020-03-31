#include <bits/stdc++.h>
using namespace std;
int main(){
	int d,s;
	cin>>d>>s;
	int a[100]={0};
	for(int i=0;i<d;i++){
		int x,y;
		cin>>x>>y;
		if(a[x]<y) a[x]=y;
	}
	sort(a,a+s,greater<int>());
	cout<<a[0]+a[1];
}