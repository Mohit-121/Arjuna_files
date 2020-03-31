import math
g_ans=[]                                               #Stores set of all the indepenedent vertex which can be robbed
def independent_sets(edges,src,n_visited,ans1):
    if(len(n_visited)==len(edges)-1):
        global g_ans
        ans2=ans1.copy()                        #If n_visited vertex includes all vertex then there are no other vertex to be
        ans2.sort()                             #processed add them to the global answer if the same set is not already present and return
        if(ans2 not in g_ans):
            g_ans.append(ans2)                                  
        return                                                
    for i in range(1,n+1):
        if(edges[src][i]==0 and i not in n_visited):
            l=[]
            for j in range(1,n+1):
                if(edges[i][j]==1 and j not in n_visited):       #For every vertex included add all the edges of a vertex
                    n_visited.add(j)                             #into n_visited(not to be visited) set
                    l.append(j)
            ans1.append(i)
            independent_sets(edges,i,n_visited,ans1)             #call backtracking function on independent_sets with that vertex
            ans1.remove(i)
            for j in l:
                n_visited.remove(j)                              #once that vertex is processed,process other vertex and find the other independent sets

n,m=map(int,input().split())
l=list(map(int,input().split()))                       #list of money that can be collected
edges=[[0 for i in range(n+1)]for j in range(n+1)]     #Edges that which has road between them
for i in range(m):
    x,y=map(int,input().split())
    edges[x][y]=edges[y][x]=1
for i in range(1,n+1):
    edges[i][i]=1                                      #Making edges between city and itself as 1
for i in range(1,n+1):
    n_visited=set()
    n_visited.add(i)                                   #For every vertex using backtracking independent sets are calculated
    for j in range(1,n+1):
        if(edges[i][j]==1):
            n_visited.add(j)
    ans=[i]
    independent_sets(edges,i,n_visited,ans)
result={}
#For every result we calculate max no of coins that can be earned along with its frequency
for i in g_ans:
    coins,dif=0,0
    for j in i:
        if(l[j-1]==0):
            dif+=1
        coins+=l[j-1]
    dif=int(math.pow(2,dif))                #If any element is zero then, we have an option either to go to that city or neglect it
    if(coins not in result.keys()):         #For 'n' zero elements we have 2^n ways of reaching to an answer by either including them or not including them
        result[coins]=dif
    else:
        result[coins]+=dif
ans=sorted(result.items(),reverse=True)           #Find out the maximum no of coins and its frequency
print(ans[0][0],ans[0][1])                        #Print maximum no of coins required









