def isSafe(s,ans):            #Defines whether by adding the plan does it exceed required plan
    for j in range(len(s)):
        if(ans[j]>s[j]):
            return False
    return True

def plan(res,s,ind,cost,ans,output):
    if(ans==s):            #If ans is same as required ans append to output
        output.append(cost)
        return
    if(not isSafe(s,ans)):  #If ans exceeds the required plan return
        return
    if(ind==len(res)):      #If plans are finished return
       return
    for j in range(len(s)):
        ans[j]+=res[ind][j]
    plan(res,s,ind,cost+res[ind][-1],ans,output)   #Choosing the plan
    for j in range(len(s)):
        ans[j]-=res[ind][j]
    plan(res,s,ind+1,cost,ans,output)             #Not choosing the plan
    return

l=list(map(int,input().split()))
l1=[];l2=[]
#making the cost of each fruit also a part of plan
for i in range(len(l)):
    l2=[0]*(len(l)+1)
    l2[i]=1
    l2[-1]=l[i]
    l1.append(l2)
n=int(input())
#Appending it to the plans
for i in range(n):
    l3=list(map(int,input().split()))
    l1.append(l3)
s=list(map(int,input().split()))   #Desired plan
ans=[0]*len(s)        
output=[]       #Contain all possible output plans cost
plan(l1,s,0,0,ans,output)      #performs backtracking to figure out all possible plans
print(min(output))             #min cost of the provided plans