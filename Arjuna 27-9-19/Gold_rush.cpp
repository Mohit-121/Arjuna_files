#include<bits/stdc++.h>
#include <sstream>
using namespace std;
int main(){
	int n,select,coins;
	//Taking in the inputs as given in the question
	cin>>select>>coins;
	string line1,line2,line3;
	vector<int> profit,required;
	getline(cin,line1);
	getline(cin,line2);
	getline(cin,line3);
	stringstream is1(line2);
	while(is1>>n){
		profit.push_back(n);
	}
	stringstream is2(line3);
	while(is2>>n){
		required.push_back(n);
	}
	for(int i=0;i<select;i++){
		int best_ind=0,best_profit=0;
		//For every chance find the best_profit and make that profit=0 when you have added it to the ans
		for(int j=0;j<profit.size();j++){
			if(required[j]<=coins && profit[j]>best_profit){
				best_ind=j;
				best_profit=profit[j];
			}
		}
		if(best_profit==0) break;   //If there is no best_profit to take anymore then break
		profit[best_ind]=0;
		coins+=best_profit;
	}
	cout<<coins<<endl;
}