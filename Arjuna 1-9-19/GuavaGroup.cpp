#include <bits/stdc++.h> 
using namespace std; 
int n;
int mergeStones(vector<int> stones, int k) {
    n = stones.size();
    if (n == 1)
        return 0;
    if ((n-1)%(k-1) != 0)
        return -1;
    int sum[n+1];
    sum[0] = 0;
    for (int i = 1; i <= n; i++)
        sum[i] = sum[i-1] + stones[i-1];
    
    vector<vector<int> > f(n+1, vector<int>(n+1));
    
    for (int j = k; j <= n; j++){
        for (int i = j-k+1; i > 0; i--) {
            int cur = INT_MAX / 2;
            for (int mid = i; mid < j; mid += k-1)
                cur = min(cur, f[i][mid] + f[mid+1][j]);
            f[i][j] = cur;
  
            if ((j-i) % (k-1) == 0)
                f[i][j] += sum[j] - sum[i-1];
        }}
    
    return f[1][n];
    }
    int main(){
    	string line;
        getline( cin, line );
        istringstream is( line );
        vector<int> v;
	int n;
	while( is >> n ) {
	  v.push_back(n);
	}
     int k;
     cin>>k;
    	cout<<mergeStones(v,k);
    }