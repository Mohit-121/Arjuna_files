#include<bits/stdc++.h>
using namespace std;
int getAnswer(int* cost,int* sellingPrice,int numIdols,int levels,int initial){
    if(numIdols==0){       //If we have no ideals left then return no of coins
        return initial;
    }
    if(levels==0){
        return INT_MIN;     //If we have exhausted levels then retunr -infinity
    }
    int option1=INT_MIN,option2=INT_MIN;  //Two options either to level up and sell or to sell the idols
    if(initial>=cost[0]){
        option1=getAnswer(cost,sellingPrice,numIdols-1,levels,initial+sellingPrice[0]-cost[0]);
    }
    option2=getAnswer(cost+1,sellingPrice+1,numIdols,levels-1,initial);
    return max(option1,option2);    //return maximum of both options
}
int main(){
    int numIdols,levels,initial;
    cin>>numIdols>>levels>>initial;   //Taking in inputs
    int* cost=new int[levels]();
    cost[0]=0;
    for(int i=1;i<levels;i++){
        cin>>cost[i];
        cost[i]+=cost[i-1];         //cost of next level will be cost of levels before that and this level
    }
    int* sellingPrice=new int[levels];
    for(int i=0;i<levels;i++){
        cin>>sellingPrice[i];        //Taking selling price as inputs
    }
    cout<<getAnswer(cost,sellingPrice,numIdols,levels,initial)<<endl; //Backtracking approach to get the solution
    delete[] sellingPrice;
    delete[] cost;                 //Deleting the arrays when job is done
}