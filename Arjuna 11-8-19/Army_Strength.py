n=int(input())
arr=[0]*100
ally = [[0 for i in range(100)] for j in range(100)]
for i in range(n):
    temp=list(map(int,input().split()))
    arr[temp[0]]=temp[1];
    for j in range(2,len(temp)):
        ally[temp[0]][temp[j]]=1
v=int(input())
ans=0
l=[]
s=[]
s.append(v)
while(len(s)!=0):
    v=s.pop()
    for k in range(1,100):
        if(ally[v][k]==1):
            s.append(k)
            ally[v][k]=0
    l.append(v)

for i in l:
    ans+=arr[i]
print(ans)